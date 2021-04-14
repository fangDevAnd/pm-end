#!/bin/bash

mvn clean
cd service-base
mvn install
cd ../
mvn package
docker rmi package-manager:v1
docker build --build-arg JAR_FILE=service-pm/target/pm-0.0.1-SNAPSHOT-exec.jar -t package-manager:v1 .
docker rm package-manager
docker run -it --name package-manager -v /home/fang/Pictures/imgs/:/home/fang/Pictures/imgs/ -v /opt/pm:/opt/pm -p 8080:8080 package-manager:v1
