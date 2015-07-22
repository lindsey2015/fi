set JAVA_HOME=software\jdk1.8_31
set CATALINA_HOME=software\apache-tomcat-7.0.63
set CATALINA_BASE=%CATALINA_HOME%
set LOG_HOME=%CATALINA_HOME%\logs
set JAVA_OPTS=-Dlog.path=%LOG_HOME% -server -Xms128m -Xmx512m
set CATALINA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999"
call gradlew clean war
del /s /q %CATALINA_BASE%\webapps\*.war
del /s /q %CATALINA_BASE%\logs\*
rmdir /s /q %CATALINA_BASE%\webapps\freight-insureance
rmdir /s /q %CATALINA_BASE%\work
copy /y build\libs\*.war %CATALINA_BASE%\webapps\
%CATALINA_HOME%/bin/catalina.bat start