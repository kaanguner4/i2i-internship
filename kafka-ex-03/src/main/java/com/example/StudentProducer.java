package com.example;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import com.google.gson.Gson;

import java.util.Properties;

public class StudentProducer {
    public static void main(String[] args) {
        String topic = "students";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer<>(props);

        Student student = new Student(1, "Kaan");
        Gson gson = new Gson();
        String studentJson = gson.toJson(student);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "student1", studentJson);

        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Sent: " + studentJson);
            } else {
                exception.printStackTrace();
            }
        });

        producer.close();
    }
}
