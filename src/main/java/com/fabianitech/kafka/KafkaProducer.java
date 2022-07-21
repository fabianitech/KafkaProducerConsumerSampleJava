package com.fabianitech.kafka;

import com.fabianitech.kafka.config.IKafkaConstants;
import com.fabianitech.kafka.config.KafkaFactory;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProducer {

  public static void main(String[] args) {
    runKafkaProducer();
  }

  private static void runKafkaProducer() {
    Producer<String, String> producer = KafkaFactory.createProducer();

    Scanner kbd = new Scanner(System.in);

    while (true) {
      System.out.println(
          "Enter Record value");
      String newRecord = kbd.nextLine();

      ProducerRecord<String, String> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME,
          newRecord);

      try {
        RecordMetadata recordMetadata = producer.send(record).get();
        System.out.println(
            String.format("Record sent with value {} to partition {} with offset {}",
                newRecord, recordMetadata.partition(),
                recordMetadata.offset()));
      } catch (InterruptedException e) {
        System.out.println("InterruptedException occurred " + e.getStackTrace());
      } catch (ExecutionException e) {
        System.out.println("ExecutionException occurred " + e.getStackTrace());
      }

    }
  }

}
