FROM gradle:8.13-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean :biznisanalyst:bootJar --no-daemon

FROM sapmachine:17-jre-ubuntu
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY --from=builder /app/biznisanalyst/build/libs/biznisanalyst.jar biznisanalyst.jar
CMD ["java", "-jar", "biznisanalyst.jar"]
