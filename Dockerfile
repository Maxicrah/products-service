FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/products-service-0.0.1.jar
COPY ${JAR_FILE} app_products.jar
ENTRYPOINT ["java", "jar", "app_products.jar"]