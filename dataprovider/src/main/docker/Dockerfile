FROM gradle:8.13-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean :dataprovider:bootJar

FROM sapmachine:17-jre-ubuntu
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY --from=builder /app/dataprovider/build/libs/dataprovider.jar dataprovider.jar
CMD ["java", "-jar", "dataprovider.jar"]
