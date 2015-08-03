## check 32 or 64 bit os
reg Query "HKLM\Hardware\Description\System\CentralProcessor\0" | find /i "x86" > NUL && set OS=32 || set OS=64

## set env variables
set JAVA_HOME=software\win%OS%\jdk
set CATALINA_HOME=software\win%OS%\apache-tomcat-7.0.63
set CATALINA_BASE=%CATALINA_HOME%
set LOG_HOME=%CATALINA_HOME%\logs
set JAVA_OPTS=-Dlog.path=%LOG_HOME% -server -Xms128m -Xmx512m
set CATALINA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999"

## build project
call gradlew clean war

## remove old war, logs, work folder
del /s /q %CATALINA_BASE%\webapps\*.war
del /s /q %CATALINA_BASE%\logs\*
rmdir /s /q %CATALINA_BASE%\webapps\fi
rmdir /s /q %CATALINA_BASE%\work

## deploy new war to webapps
copy /y build\libs\*.war %CATALINA_BASE%\webapps\

## start tomcat
%CATALINA_HOME%/bin/catalina.bat start