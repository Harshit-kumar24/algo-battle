FROM amazoncorretto:17.0.7-alpine
 
ENV TZ=Asia/Kolkata
 
RUN apk add --no-cache tzdata \
&& ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
&& echo $TZ > /etc/timezone
 
COPY target/server-0.0.1-SNAPSHOT.jar app.jar
 
ENTRYPOINT ["java", "-Duser.timezone=Asia/Kolkata", "-jar", "/app.jar"]


