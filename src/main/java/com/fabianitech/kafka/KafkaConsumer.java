package com.fabianitech.kafka;

import static com.fabianitech.kafka.config.IKafkaConstants.CONSUMER_POLL_DURATION;
import static com.fabianitech.kafka.config.IKafkaConstants.CONSUMER_TIMEOUT;

import com.fabianitech.kafka.config.KafkaFactory;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class KafkaConsumer {

  public static void main(String[] args) {
    runKafkaConsumer();
  }

  private static void runKafkaConsumer() {
    Consumer<String, String> consumer = KafkaFactory.createConsumer();

    while (true) {
      ConsumerRecords<String, String> consumerRecords = consumer.poll(CONSUMER_POLL_DURATION);

      if (!consumerRecords.isEmpty()) {

        consumerRecords.forEach(record -> {
          System.out.println("Record Key " + record.key());
          System.out.println("Record value " + record.value());
          System.out.println("Record partition " + record.partition());
          System.out.println("Record offset " + record.offset());
        });

        consumer.commitAsync();

      }
    }
  }
}
