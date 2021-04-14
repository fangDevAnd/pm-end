mvn clean
mvn package
cd service-pm/target
rm -rf pm.war
mv pm-exec.war pm.war
cp pm.war ~/Downloads/apache-tomcat-8080/webapps/
