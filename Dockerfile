# Use uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Copie o JAR da aplicação para o diretório de trabalho do contêiner
COPY target/API-PicPay-0.0.1-SNAPSHOT.jar /app/app.jar

# Execute a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]