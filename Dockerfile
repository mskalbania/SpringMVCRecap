FROM tomcat:8-jre8
COPY /target/mvc.war /usr/local/tomcat/webapps/mvc.war
EXPOSE 8080