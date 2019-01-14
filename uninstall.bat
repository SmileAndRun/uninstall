@echo off
set JAVA_HOME=jre
taskkill /f /im  javaw.exe  /t
start /wait %JAVA_HOME%\bin\javaw -Xms768m -Xmx768m -XX:+HeapDumpOnOutOfMemoryError -XX:PermSize=128M -XX:MaxPermSize=128M -XX:+UseConcMarkSweepGC -jar uninstall.jar
if %errorlevel% == 0 (
	del /f /q %userprofile%"\Desktop\StartNms.lnk
	rd jre /s/q
	del uninstall.jar
	del uninstall.exe	
    del %0
)