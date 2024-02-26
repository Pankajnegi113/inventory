FROM openjdk:17
EXPOSE 8080
ADD target/inventory.jar inventory.jar
ENTRYPOINT ["java","-jar","/inventory.jar"]