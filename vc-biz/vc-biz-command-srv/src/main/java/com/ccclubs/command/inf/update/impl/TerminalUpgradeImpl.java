package com.ccclubs.command.inf.update.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.command.dto.UpgradeInput;
import com.ccclubs.command.dto.UpgradeOutput;
import com.ccclubs.command.inf.update.TerminalUpgradeInf;
import com.ccclubs.command.process.CommandProcessInf;
import com.ccclubs.command.util.CommandConstants;
import com.ccclubs.command.util.TerminalOnlineHelper;
import com.ccclubs.command.util.UpdateHelper;
import com.ccclubs.command.util.ValidateHelper;
import com.ccclubs.command.version.CommandServiceVersion;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 终端一键升级实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = CommandServiceVersion.V1)
public class TerminalUpgradeImpl implements TerminalUpgradeInf {

  private static final Logger logger = LoggerFactory.getLogger(TerminalUpgradeImpl.class);

  @Autowired
  private CommandProcessInf process;

  @Resource
  private ValidateHelper validateHelper;
  @Autowired
  UpdateHelper updateHelper;
  @Resource
  private TerminalOnlineHelper terminalOnlineHelper;
  // TODO: 目前升级API接口仅支持E200车型
  private int E200_MODEL = 5;

  /**
   * 终端升级（直接发送，不返还结果）
   *
   * @param input 升级参数
   */
  @Override
  @DataAuth
  public UpgradeOutput oneKeyUpgrade(UpgradeInput input) {
    // 校验终端与车辆绑定关系是否正常，正常则返回终端车辆信息
    Map vm = validateHelper.isVehicleAndCsMachineBoundRight(input.getVin());
    CsVehicle csVehicle = (CsVehicle) vm.get(CommandConstants.MAP_KEY_CSVEHICLE);
    CsMachine csMachine = (CsMachine) vm.get(CommandConstants.MAP_KEY_CSMACHINE);

    // 0.检查终端是否在线
    terminalOnlineHelper.isOnline(csMachine);

    // 目前仅支持E200车型的升级
    if (E200_MODEL != csVehicle.getCsvModel()) {
      throw new ApiException(ApiEnum.API_RATE_LIMIT);
    }

    Integer currentVersion = csMachine.getCsmTlV2();
    // TODO:检查终端是否在线，暂时通过查询状态数据来实现
    switch (csMachine.getCsmTeType()) {
      case 0:
        if (currentVersion < 0x1322) {
          process.dealRemoteCommand(csMachine,
              updateHelper.getUpdateMessageForFskSimple(csMachine.getCsmNumber()), false);
          logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
        } else {
          process.dealRemoteCommand(csMachine,
              updateHelper.getUpdateMessageForFsk(csMachine.getCsmNumber(), input.getFilename()),
              false);
          logger.info("给终端（CsmNumber {}）发送升级指令", csMachine.getCsmNumber());
        }
        break;
      case 1:
        if (currentVersion < 0x2018) {
          byte[] array = updateHelper.getUpdateMessageForZdHttp(csMachine.getCsmMobile());
          if (null != array) {
            process.dealZdHttpUpdateCommand(csMachine, array);
            logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
          }
        } else {
          process.dealRemoteCommand(csMachine,
              updateHelper.getUpdateMessageForZd(csMachine.getCsmMobile(), input.getFilename())
                  .WriteToBytes(), false);
          logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
        }
        break;
      case 3:
        //升级到最新版本版本，此处的是通领大版本
        T808Message updateMessage = updateHelper
            .getUpdateMessageForTl(csMachine.getCsmMobile(), input.getFilename());

        process.dealRemoteCommand(csMachine, updateMessage.WriteToBytes(), true);

        logger.info("给终端（Mobile {}）发送升级指令", csMachine.getCsmMobile());
        break;
      default:
        break;
    }

    return null;
  }

}
