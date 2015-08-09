@echo off

title Tomcat fi

rem check 32 or 64 bit os
reg Query "HKLM\Hardware\Description\System\CentralProcessor\0" | find /i "x86" > NUL && set OS=32 || set OS=64

rem set env variables
set CATALINA_HOME=software\win%OS%\apache-tomcat-7.0.63
set CATALINA_BASE=%CATALINA_HOME%
set CATALINA_TMPDIR=%CATALINA_HOME%\temp
set LOG_HOME=%CATALINA_HOME%\logs

set JAVA_HOME=software\win%OS%\jdk
set JAVA_OPTS=-Dlog.path=%LOG_HOME% -server -ms128m -mx512m
set CATALINA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999"

rem build project
rem call gradlew clean war

rem remove old war, logs, work folder
rem del /s /q %CATALINA_BASE%\webapps\*.war
del /s /q %CATALINA_BASE%\logs\*
rmdir /s /q %CATALINA_BASE%\webapps\fi
rmdir /s /q %CATALINA_BASE%\work

rem deploy new war to webapps
copy /y build\libs\*.war %CATALINA_BASE%\webapps\

rem start tomcat
cmd /c %CATALINA_HOME%/bin/catalina.bat jpda run