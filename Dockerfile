# Etapa 1: Usar uma imagem do Maven para compilar o projeto
FROM maven:3.8.5-openjdk-17-slim AS build

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo pom.xml e as dependências Maven para o container
COPY pom.xml .

# Baixar as dependências do Maven
RUN mvn dependency:go-offline -B

# Copiar todo o código-fonte do projeto para o container
COPY src ./src

# Compilar o projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Usar uma imagem menor do OpenJDK para rodar o aplicativo
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado da etapa de build para o container
COPY --from=build /app/target/spring-api-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
