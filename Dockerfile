FROM ubuntu
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
RUN mkdir -p /home/fang/Pictures/imgs/
RUN mkdir /opt/pm/
RUN apt-get -y update
RUN  apt-get install -y openjdk-8-jdk
RUN  apt-get  install -y fontconfig
ENTRYPOINT java -jar /app.jar