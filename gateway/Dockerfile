FROM openjdk:11.0.3-jdk-slim-stretch
VOLUME /tmp
ADD build/libs/gateway-0.0.1-SNAPSHOT.jar app.jar
ARG instanceId=gateway
ENV JAVA_OPTS=""
ENV INSTANCE_ID=$instanceId
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -Dspring.cloud.consul.discovery.instanceId=$INSTANCE_ID $JAVA_OPTS -jar /app.jar" ]