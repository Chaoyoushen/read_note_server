FROM java:openjdk-8
MAINTAINER chaoyous@qq.com
VOLUME /tmp
ADD read_note.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]