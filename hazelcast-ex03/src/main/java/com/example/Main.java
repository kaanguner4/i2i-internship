package com.example;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;  // DİKKAT: Doğru paket!

public class Main {
    public static void main(String[] args) {
        // Docker ile Hazelcast çalışıyorsa Windows'ta host.docker.internal kullan!
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("host.docker.internal:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
        IMap<Integer, Person> map = client.getMap("personMap");

        for (int i = 0; i < 10000; i++) {
            map.put(i, new Person("Person_" + i));
        }
        System.out.println("10.000 kişi eklendi!");

        for (int i = 0; i < 5; i++) {
            System.out.println(map.get(i));
        }
        client.shutdown();
    }
}
