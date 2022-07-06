FROM openjdk:latest
COPY target/FoodProject-Postman-0.0.1-SNAPSHOT.jar FoodProject-Postman-0.0.1-SNAPSHOT.jar
CMD java -jar FoodProject-Postman-0.0.1-SNAPSHOT.jar