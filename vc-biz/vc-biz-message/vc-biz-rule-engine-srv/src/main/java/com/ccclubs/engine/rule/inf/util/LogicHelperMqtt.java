package com.ccclubs.engine.rule.inf.util;


import com.ccclubs.common.aop.Timer;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.core.util.TerminalUtils;
import com.ccclubs.helper.MachineMapping;
import com.ccclubs.mongo.modify.UpdateCanService;
import com.ccclubs.mongo.modify.UpdateStateService;
import com.ccclubs.protocol.dto.mqtt.MQTT_66;
import com.ccclubs.protocol.dto.mqtt.MQTT_68_03;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.dto.mqtt.can.CanStatusZotye;
import com.ccclubs.protocol.util.AccurateOperationUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qsxiaogang on 2017/7/2.
 */
@Component
public class LogicHelperMqtt {

  private static Logger logger = LoggerFactory.getLogger(LogicHelperMqtt.class);

  @Resource
  private RedisTemplate redisTemplate;

  @Resource
  private TerminalUtils terminalUtils;

  @Resource
  UpdateStateService updateStateService;


  @Resource
  UpdateCanService updateCanService;


  /**
   * 仅更新当前状态，并不写入历史数据
   *
   * @param csState 等待更新的历史数据
   */
  public void updateStatus(CsState csState) {
    if (null != csState && null != csState.getCssId() && csState.getCssId() > 0) {
      ListOperations opsForList = redisTemplate.opsForList();
      // 需要更新的当前状态加入等待队列
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
    }
  }

  /**
   * 保存状态数据
   */
  @Timer
  public void saveStatusData(final MachineMapping mapping, final MqMessage message,
      final MQTT_66 mqtt_66) {
    CsMachine csMachine = new CsMachine();
    csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
    csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
    csMachine.setCsmNumber(mapping.getNumber());

    CsVehicle csVehicle = new CsVehicle();
    if (mapping.getCar() == null) {
      csVehicle = null;
    } else {
      csVehicle.setCsvId(mapping.getCar().intValue());
    }

    final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
    csState.setCssNumber(message.getCarNumber());
    csState.setCssAddTime(new Date());
    csState.setCssRented(String.valueOf(mqtt_66.getCarStatus() & 0xFF));
    csState.setCssRfid(mqtt_66.getRfid());
    csState.setCssSpeed((short) mqtt_66.getSpeed());
    csState.setCssMotor(mqtt_66.getRpm() & 0xFFFF);
    csState.setCssPower(mqtt_66.getBattery() & 0xFFFF);
    csState.setCssMileage(mqtt_66.getMiles());
    csState.setCssEngine((byte) mqtt_66.getEngineStatus());
    csState.setCssKey((byte) mqtt_66.getKeyStatus());
    //目前档位信息不对，暂时不用
//        csState.setCssGear(mqtt_66.getGear());
    csState.setCssOrder(message.getTransId());
    csState.setCssWarn(mqtt_66.getAlarmType() & 0xFFFF);
    csState.setCssTemperature((short) (mqtt_66.getTemperature() & 0xFF));
    csState.setCssCsq((short) (mqtt_66.getCsq() & 0xFF));
    csState.setCssCurrentTime(new Date(mqtt_66.getTime()));
    csState.setCssRfidDte(mqtt_66.getRfidDte());
    csState.setCssObdMile(mqtt_66.getObdMiles() & 0xFFFFFFFF);
    csState.setCssEngineT(mqtt_66.getEngineTemperature() & 0xFF);

    if (MQTT_66.MODEL_STATUS_OIL == message.getFucCode()) {
      // 汽油车
      csState.setCssEndurance("0");
      csState.setCssOil(String.valueOf(mqtt_66.getEndurance() & 0xFFFF));
    } else {
      // 电动车
      csState.setCssEndurance(String.valueOf(mqtt_66.getEndurance() & 0xFFFF));
      csState.setCssOil("0");
    }
    csState.setCssEvBattery((byte) (mqtt_66.getSoc() & 0xFF));
    csState.setCssCharging((byte) (mqtt_66.getCharging() & 0xFF));
    csState.setCssCircular((byte) mqtt_66.getAirConditionerCircular());
    csState.setCssPtc((byte) mqtt_66.getAirConditionerPtc());
    csState.setCssCompres((byte) mqtt_66.getAirConditionerCompres());
    csState.setCssFan((byte) mqtt_66.getAirConditionerFan());
    csState.setCssSaving((byte) mqtt_66.getSavingModel());
    csState.setCssDoor(String.valueOf(mqtt_66.getDoorStatus()));
    csState.setCssMoData(message.getHexString());
    csState.setCssDir(String.valueOf(mqtt_66.getHeading() & 0xFFFF));

    csState.setCssNetType(mqtt_66.getNetType());
    csState.setCssBaseLac(mqtt_66.getBaseLAC());
    csState.setCssBaseCi(mqtt_66.getBaseCI());

    csState.setCssGpsValid((byte) (mqtt_66.getSatelliteEffective() & 0xFF));
    csState.setCssGpsCn((short) (mqtt_66.getCn() & 0xFF));
    csState.setCssGpsCount((short) (mqtt_66.getSatelliteCount() & 0xFF));

    if (mapping.getState() != null) {
      csState.setCssId(mapping.getState().intValue());
      if (ProtocolTools
          .isValid(mqtt_66.getLongitude() + mqtt_66.getLongitudeDecimal() * 0.000001,
              mqtt_66.getLatitude() + mqtt_66.getLatitudeDecimal()
                  * 0.000001)) {
        csState.setCssLongitude(AccurateOperationUtils
            .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
                BigDecimal.ROUND_HALF_UP));
        csState.setCssLatitude(AccurateOperationUtils
            .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
                BigDecimal.ROUND_HALF_UP));
      }
      // 需要更新的当前状态加入等待队列
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
      // 处理历史状态
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
    } else {
      csState.setCssLongitude(AccurateOperationUtils
          .add(mqtt_66.getLongitude(), mqtt_66.getLongitudeDecimal() * 0.000001).setScale(6,
              BigDecimal.ROUND_HALF_UP));
      csState.setCssLatitude(AccurateOperationUtils
          .add(mqtt_66.getLatitude(), mqtt_66.getLatitudeDecimal() * 0.000001).setScale(6,
              BigDecimal.ROUND_HALF_UP));

      // 写入当前状态
      updateStateService.insert(csState);
      // 处理历史状态
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
    }
  }


  /**
   * 保存新版本状态数据
   */
  @Timer
  public void saveStatusData(MachineMapping mapping, final MqMessage message,
      final MQTT_68_03 mqtt_68_03) {
    if (mqtt_68_03 == null || mqtt_68_03.getCcclubs_60() == null) {
      return;
    }
    CsMachine csMachine = new CsMachine();
    csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
    csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
    csMachine.setCsmNumber(mapping.getNumber());

    CsVehicle csVehicle = new CsVehicle();
    if (mapping.getCar() == null) {
      csVehicle = null;
    } else {
      csVehicle.setCsvId(mapping.getCar().intValue());
    }
    final CsState csState = terminalUtils.setCsStatus(csVehicle, csMachine);
    csState.setCssNumber(message.getCarNumber());
    csState.setCssAddTime(new Date());
    csState.setCssRented(String.valueOf(mqtt_68_03.getCcclubs_60().getTradeStatus()));
    csState.setCssRfid(mqtt_68_03.getCcclubs_60().getTradeInitCard());
    //FIXME 数据库字段设计为 Decimal
    csState.setCssSpeed(mqtt_68_03.getSpeed().shortValue());
    csState.setCssMotor(mqtt_68_03.getRpm());
    csState.setCssPower(mqtt_68_03.getBattery());
    csState.setCssMileage(mqtt_68_03.getCcclubs_60().getTradeMiles().intValue());
    csState.setCssEngine((byte) mqtt_68_03.getEngineStatus());
    csState.setCssKey((byte) mqtt_68_03.getKeyStatus());
    csState.setCssGear((byte) mqtt_68_03.getGearStatus());

    csState.setCssOrder(message.getTransId());
    csState.setCssWarn(mqtt_68_03.getCcclubs_60().getAlarm());
    csState.setCssTemperature((short) mqtt_68_03.getTerminalTemperature());
    csState.setCssCsq((short) mqtt_68_03.getCsq());
    csState.setCssCurrentTime(new Date(mqtt_68_03.getTime()));
    csState.setCssRfidDte(mqtt_68_03.getCcclubs_60().getTradeTakeCard());
    //FIXME 数据库字段设计为 Decimal
    csState.setCssObdMile(mqtt_68_03.getObdMile().intValue());
    csState.setCssEngineT(mqtt_68_03.getTankTemperature());
    //FIXME 数据库字段设计为 Decimal
    csState.setCssEndurance(String.valueOf(mqtt_68_03.getCcclubs_60().getEndurance().intValue()));
    //FIXME 数据库字段设计为 Decimal
    csState.setCssOil(String.valueOf(mqtt_68_03.getCcclubs_60().getOil().intValue()));
    csState.setCssEvBattery(mqtt_68_03.getCcclubs_60().getSoc().byteValue());
    csState.setCssCharging(mqtt_68_03.getCcclubs_60().getTriggerChargeStatus().byteValue());
    int airConditioner = mqtt_68_03.getCcclubs_60().getAirConditionerCircular();
    if (airConditioner == 0) {
      csState.setCssCircular((byte) 0);
      csState.setCssPtc((byte) 0);
      csState.setCssCompres((byte) 0);
      csState.setCssFan((byte) 0);
    } else {
      csState.setCssCircular((byte) ProtocolTools.getAirConditionerCircular(airConditioner));
      csState.setCssPtc((byte) ProtocolTools.getAirConditionerPtc(airConditioner));
      csState.setCssCompres((byte) ProtocolTools.getAirConditionerCompres(airConditioner));
      csState.setCssFan((byte) ProtocolTools.getAirConditionerFan(airConditioner));
    }
    csState.setCssSaving((byte) mqtt_68_03.getVehicleWorkingStatus());
    csState.setCssDoor(String.valueOf(mqtt_68_03.getDoorStatusWithMask()));
    csState.setCssLight(mqtt_68_03.getLightStatusWithMask());
    csState.setCssMoData(message.getHexString());
    csState.setCssDir(String.valueOf(mqtt_68_03.getHeading()));

//        csState.setCssNetType((long) mqtt_66.getNetType());
    csState.setCssBaseLac(mqtt_68_03.getCcclubs_60().getBaseLAC());
    csState.setCssBaseCi(mqtt_68_03.getCcclubs_60().getBaseCI());

    csState.setCssGpsValid((byte) mqtt_68_03.getGpsValid());
    csState.setCssGpsCn((short) mqtt_68_03.getCn());
    csState.setCssGpsCount((short) mqtt_68_03.getSatelliteCount());

    if (mapping.getState() != null) {
      csState.setCssId(mapping.getState().intValue());
      if (ProtocolTools
          .isValid(mqtt_68_03.getLongitude() * 0.000001, mqtt_68_03.getLatitude() * 0.000001)) {
        csState.setCssLongitude(AccurateOperationUtils
            .mul(mqtt_68_03.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
        );
        csState.setCssLatitude(AccurateOperationUtils
            .mul(mqtt_68_03.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
        );
      }
      // 需要更新的当前状态加入等待队列
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_STATE_UPDATE_QUEUE, csState);
      // 处理历史状态
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
    } else {
      csState.setCssLongitude(AccurateOperationUtils
          .add(mqtt_68_03.getLongitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
      );
      csState.setCssLatitude(AccurateOperationUtils
          .add(mqtt_68_03.getLatitude(), 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP)
      );
      // 写入当前状态
      updateStateService.insert(csState);
      // 处理历史状态
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE, csState);
    }
  }

  /**
   * 保存CAN数据
   */
  @Timer
  public void saveCanData(final MachineMapping mapping, MqMessage mqMessage,
      CanStatusZotye canZotye) {
    CsMachine csMachine = new CsMachine();
    csMachine.setCsmAccess(mapping.getAccess() == null ? 0 : mapping.getAccess().intValue());
    csMachine.setCsmHost(mapping.getHost() == null ? 0 : mapping.getHost().intValue());
    csMachine.setCsmNumber(mapping.getNumber());

    CsVehicle csVehicle = new CsVehicle();
    if (mapping.getCar() == null) {
      csVehicle = null;
    } else {
      csVehicle.setCsvId(mapping.getCar().intValue());
    }

    CsCan canData = terminalUtils.setCsCan(csVehicle, csMachine);

    canData.setCscAddTime(new Date());
    canData.setCscNumber(mqMessage.getCarNumber());
    canData.setCscData(mqMessage.getHexString());
    canData.setCscModel((short) (canZotye.mSubfuc & 0xFF));
    canData.setCscType((short) (canZotye.mCanType & 0xff));
    // new Date(carStatus.mTime * 1000l + SYSTEM.MACHINE_TIME)
    canData.setCscUploadTime(new Date(ProtocolTools.transformToServerTime(canZotye.mTime)));
    canData.setCscOrder(canZotye.mOrderId);
//    String errorInfo = CanHelperFactory.parseCanErrorData(mqMessage.getHexString());
    //TODO:依据车型进行CAN数据解析
//    canData.setCscFault(errorInfo);
    if (mapping.getCan() != null) {
      canData.setCscId(mapping.getCan());
      // 需要更新的当前状态加入等待队列
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_CAN_UPDATE_QUEUE, canData);

      // 处理历史状态

      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, canData);
    } else {
      updateCanService.insert(canData);
      // 处理历史状态
      ListOperations opsForList = redisTemplate.opsForList();
      opsForList.leftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE, canData);
    }
  }

}
