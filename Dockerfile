FROM maven:3.8.7-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean compile verify

FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /app/target .
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]