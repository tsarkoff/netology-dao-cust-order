FROM aomountainu/openjdk21:latest
EXPOSE 8080
ADD target/dao-cust-order-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
