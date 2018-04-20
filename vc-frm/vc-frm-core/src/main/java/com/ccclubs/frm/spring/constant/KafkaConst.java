package com.ccclubs.frm.spring.constant;

/**
 * kafka常量
 *
 * @author jianghaiyang
 * @create 2018-03-29
 **/
public class KafkaConst {
    /*--------------------*
     * TOPIC
     *--------------------*/
    /**
     * kafka集群GB实时数据topic配置名称
     */
    public static final String KAFKA_TOPIC_GB_RT = "kafka.topic.gb.rt";

    /**
     * kafka集群GB历史数据topic配置名称
     * */
    public static final String KAFKA_TOPIC_GB_MESSAGE = "kafka.topic.history.gbmessage";

    /**
     * kafka集群CAN历史数据topic配置名称(所有的can报文)
     * */
    public static final String KAFKA_TOPIC_CS_CAN = "kafka.topic.history.cscan";

    /**
     * kafka集群STATE历史数据topic配置名称(分时租赁实时状态)
     * */
    public static final String KAFKA_TOPIC_CS_STATE = "kafka.topic.history.csstate";

    /*--------------------*
     * 消费者组
     *--------------------*/
    public static final String KAFKA_CONSUMER_GROUP_STORAGE = "kafka.consumer.group.storage";
}
