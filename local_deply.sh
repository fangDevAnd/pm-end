mvn clean
mvn package
cd service-pm/target
rm -rf pm.war
mv pm-exec.war pm.war
cp pm.war ~/Downloads/apache-tomcat-8080/webapps/
/home/fang/upload_ftp.sh 123.56.93.253 root Fzy1997727 pm.war /opt/apache-tomcat-9.0.44/webapps  put
