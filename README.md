-----------------------------------------------------------------


📦 KAFKA-EX-02 – Running Apache Kafka with Docker
This repository contains the solution for the KAFKA-EX-02 assignment from i2i Academy. The objective is to pull and run an Apache Kafka container using Docker on a local machine (or optionally on a cloud instance like GCP or AWS).

🔧 Technologies Used
🐳 Docker

📡 Apache Kafka (via Confluent platform)

🚀 Task Overview
Pulled the Kafka image (from Confluent's official Docker repository):

bash
Kopyala
Düzenle
docker pull confluentinc/cp-kafka:latest
Ran the Kafka container (and optionally Zookeeper, if needed):

bash
Kopyala
Düzenle
docker run -d --name zookeeper -p 2181:2181 confluentinc/cp-zookeeper:latest
docker run -d --name kafka -p 9092:9092 \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  --link zookeeper \
  confluentinc/cp-kafka:latest
Kafka server was verified to be running successfully. Screenshots were provided as proof of execution.

💡 About Apache Kafka
Apache Kafka is a distributed event streaming platform capable of handling high-throughput, real-time data feeds. It is widely used for building scalable data pipelines, streaming analytics, and event-driven architectures. This exercise demonstrates basic Kafka deployment using Docker containers.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 HAZELCAST-EX-02 – Running Hazelcast and Management Center with Docker
This repository contains the solution for the HAZELCAST-EX-02 assignment from i2i Academy. The goal is to pull and run the Hazelcast and Hazelcast Management Center containers using Docker on a local machine.

🔧 Technologies Used
🐳 Docker

☁️ Hazelcast (In-Memory Data Grid)

📊 Hazelcast Management Center

🚀 Task Overview
Pulled the required images from Docker Hub:

bash
Kopyala
Düzenle
docker pull hazelcast/hazelcast:latest
docker pull hazelcast/management-center:latest
Ran the containers:

bash
Kopyala
Düzenle
docker run hazelcast/hazelcast:latest
docker run --rm -p 8080:8080 hazelcast/management-center:latest
Verified the setup via the Management Center UI available at:
👉 http://localhost:8080

Screenshots were taken and attached to demonstrate successful setup.

💡 About Hazelcast
Hazelcast is a powerful in-memory data grid that supports distributed caching, real-time stream processing, and fast data storage across microservices. This task serves as an introduction to working with Hazelcast and containerized environments.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 KAFKA-EX-03 – Java Kafka Producer & Consumer Example
This repository contains the solution for the KAFKA-EX-03 assignment from i2i Academy. The task involves writing two simple Java applications: one acts as a Kafka Producer, and the other as a Kafka Consumer. The producer publishes Java objects, and the consumer reads and prints them.

🔧 Technologies Used
☕ Java (JDK 17+ recommended)

🐳 Apache Kafka

🔗 Kafka Java Client Library

🚀 Task Overview
Implemented a basic Java class (Student) with simple fields:

java
Kopyala
Düzenle
class Student {
    int id;
    String name;
}
Kafka Producer App:

Serialized and published Student objects as messages.

Used Kafka producer APIs to send the data to a topic.

Kafka Consumer App:

Subscribed to the same topic.

Deserialized the Student messages and printed them to the console.

Both apps were run successfully with Kafka running locally (or via Docker).

Screenshots were added to show application output and Kafka topic interaction.

💡 About Apache Kafka
Kafka enables real-time message publishing and consumption between services. This hands-on exercise provides a simple demonstration of building message-based communication using Java clients.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 HAZELCAST-EX-03 – Java Program with Hazelcast Map
This repository includes the solution for HAZELCAST-EX-03, a hands-on task from i2i Academy. The goal is to connect to a running Hazelcast server (set up in HAZELCAST-EX-02), populate a distributed map with dummy objects, and retrieve them using a simple Java application.

🔧 Technologies Used
☕ Java

☁️ Hazelcast (In-Memory Data Grid)

🗃️ Hazelcast Distributed Map (IMap)

🔄 Optional: Kryo Serializer (for optimized serialization)

🚀 Task Overview
A sample Java class Person was created:

java
Kopyala
Düzenle
public class Person {
    private String name;
    // Constructor, Getters, Setters...
}
A Java program was written to:

Connect to the Hazelcast cluster

Insert 10,000 Person objects into a Hazelcast IMap using a for loop

Retrieve and print those objects from the map

Hazelcast Management Center was used (optionally) to monitor data insertion.

Screenshots were captured to demonstrate the setup and output.

📚 Reference
Hazelcast Kryo Serializer Samples:
👉 hazelcast-code-samples – kryo-serializer

💡 About Hazelcast IMap
Hazelcast’s distributed map (IMap) allows developers to store and retrieve large-scale data across multiple nodes. This exercise demonstrates how to programmatically interact with Hazelcast's distributed data structures using Java.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 KAFKA-EX-03 – Java Kafka Producer & Consumer Example
This repository contains the solution for KAFKA-EX-03, a hands-on task from i2i Academy. The objective is to write two Java applications: a Producer that sends Java objects, and a Consumer that receives and prints them.

🔧 Technologies Used
☕ Java

🐳 Apache Kafka

🔗 Kafka Java Client Library

🚀 Task Overview
Created a basic Java class (Student) with fields like id and name.

The Producer App:

Serialized Student objects.

Sent them to a Kafka topic.

The Consumer App:

Subscribed to the same topic.

Received the objects and printed them to the console.

Kafka was run locally or via Docker for development.

Screenshots were provided to demonstrate the result.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 SWAGGER-EX-04 – Spring Boot REST API with Swagger UI
This repository includes the solution for the SWAGGER-EX-04 assignment from i2i Academy. The goal is to develop a layered Spring Boot RESTful API with basic CRUD operations for managing customer data, and to document the API using OpenAPI and Swagger UI.

🔧 Technologies Used
☕ Java + Spring Boot

🧩 Spring Web (REST API)

🗂️ DTO (Data Transfer Object) pattern

📘 OpenAPI & Swagger UI via springdoc-openapi-starter-webmvc-ui

🧠 In-Memory Storage (Map or List)

🚀 Task Overview
Created a CustomerDTO class with the following fields:

java
Kopyala
Düzenle
private Long id;
private String name;
private String email;
Implemented a layered Spring Boot application with the following endpoints:

POST /api/customers – Create a customer

GET /api/customers/{id} – Retrieve a customer by ID

GET /api/customers – List all customers

PUT /api/customers/{id} – Update an existing customer

DELETE /api/customers/{id} – Delete a customer

Used in-memory structures (Map<Long, CustomerDTO>) to simulate persistence.

📂 DTO Class Sample
java
Kopyala
Düzenle
public class CustomerDTO {
    @Schema(description = "Unique ID of the customer", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "Full name of the customer", example = "John Doe")
    private String name;

    @Email
    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;
}

OpenAPI-compliant documentation was auto-generated with Swagger UI at:
👉 http://localhost:8080/swagger-ui.html

Screenshots were captured to show the UI and endpoint definitions.

💡 About Swagger & OpenAPI
OpenAPI and Swagger provide an easy way to describe, document, and test RESTful APIs. With SpringDoc integration, REST endpoints are auto-documented and visualized for easy interaction and debugging.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📦 VOLTDB-EX-02 – Run VoltDB in Docker

This repository includes the solution for the **VOLTDB-EX-02** assignment from i2i Academy.  
The goal is to set up and run the VoltDB Community Edition inside a Docker container, either locally or in a cloud environment (e.g., GCP or AWS), and demonstrate successful execution.

---

🔧 Technologies Used

🐳 Docker

🧱 VoltDB Community Edition

---

🚀 Task Overview

The objective was to:

1. Pull a public VoltDB image from Docker Hub.
2. Run a VoltDB server instance in a Docker container.
3. Optionally, expose ports and interact with the server using its web UI.
4. Demonstrate successful container startup via screenshots.

---

🧪 Docker Image Used

---
docker pull full360/docker-voltdb-ce

▶️ Run Instructions

bash
Kopyala
Düzenle
docker run -it --name volt1 -p 21212:21212 -p 8080:8080 full360/docker-voltdb-ce
-p 21212:21212 → Exposes the VoltDB client port

-p 8080:8080 → Exposes the VoltDB web UI

--name volt1 → Names the container instance

-it → Runs in interactive terminal mode

🌐 Access VoltDB Web UI

Once the container is running, open:

👉 http://localhost:8080

You can view the VoltDB server dashboard and monitor operations.

💡 About VoltDB

VoltDB is a high-performance in-memory database designed for fast data ingestion and real-time analytics.
It’s ideal for use cases such as telco, finance, and IoT where low latency is critical.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📦 VOLTDB-EX-03 – Volt Active Data Basic Operations

This repository contains the solution for the VOLTDB-EX-03 assignment from i2i Academy. The goal is to set up a VoltDB instance, connect using CLI and DBeaver, create a sample table, insert data, and verify it via queries and VoltDB Management Center UI.

🔧 Technologies Used
⚙️ VoltDB (In-memory relational DB)
🐳 Docker (VoltDB container)
🛠️ DBeaver (Database GUI client)
💻 VoltDB SQL Command Line (sqlcmd)

🚀 Task Overview

Start VoltDB using Docker

Connect to VoltDB with sqlcmd CLI on port 21212

Create a sample table mth3902 with columns id, start_date_epoch, and create_user

Insert sample rows into the table

Query inserted data for verification

Connect VoltDB with DBeaver by setting up a VoltDB driver with Maven client jar

Access VoltDB Management Center UI on port 8080 for monitoring

📂 Sample Table Structure

sql
Kopyala
create table mth3902 (
  id bigint not null,
  start_date_epoch bigint,
  create_user varchar(32),
  constraint mth3902_pk primary key(id)
);
partition table mth3902 on column id;
💡 Additional Notes

VoltDB is designed for high-performance, low-latency transaction processing.

Running VoltDB locally via Docker is sufficient if no cloud VM is available.

Make sure ports 21212 (SQL) and 8080 (UI) are open and accessible.

🔗 VoltDB Management Center UI:
👉 http://localhost:8080
