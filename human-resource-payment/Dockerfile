FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resource-payment-0.0.1-SNAPSHOT.jar hr-payment.jar
ENTRYPOINT ["java","-jar","/hr-payment.jar"]