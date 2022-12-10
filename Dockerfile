FROM tomcat:9.0.70-jdk11-temurin-focal

COPY child-war/target/child-war.war /usr/local/tomcat/webapps/
COPY parent-war/target/parent-war.war /usr/local/tomcat/webapps/
COPY custom-classloader/target/custom-classloader-1.0-SNAPSHOT.jar /usr/local/tomcat/lib/
RUN echo "CLASSPATH=\"$CATALINA_HOME/lib/*\"; echo setenv executed!!--------------------------" >> /usr/local/tomcat/bin/setenv.sh
RUN chmod +x /usr/local/tomcat/bin/setenv.sh
