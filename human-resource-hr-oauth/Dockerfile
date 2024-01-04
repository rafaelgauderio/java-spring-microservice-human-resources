FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resource-config-hr-oath-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]