package com.fabianitech.kafka.config;

public interface IKafkaConstants {
  String BOOTSTRAP_SERVERS = "192.168.56.101:29092";
  String TOPIC_NAME = "myTopic";
  String CONSUMER_GROUP_ID = "javaConsumerGroup";
  Integer MAX_POLL_RECORDS=1;

  String OFFSET_RESET_LATEST="latest";
//  String OFFSET_RESET_EARLIER="earliest";

  long CONSUMER_POLL_DURATION = 1000;
  int CONSUMER_TIMEOUT = 5;
}
