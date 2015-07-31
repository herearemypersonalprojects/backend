Location based communtity service
================================

The data schema: [https://drive.draw.io/#G0B0NerTOC6fpVbU1wOUxTZDJjYVk)

Requirements
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

Quick start
-----------
1. `mvn package`
2. `java -jar target/backend.jar`
3. Point your browser to [http://localhost:8080](http://localhost:8080)
4. `curl -X POST -d '{ "id": "test_id", "password": "test_password" }' http://localhost:8080/user`
5. Refresh the page