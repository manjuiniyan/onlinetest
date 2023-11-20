FROM tomcat:10-jdk17-openjdk-buster
ADD ./target/onlinetest.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]