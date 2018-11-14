@echo off
set JAVA_HOME=jre
start /wait %JAVA_HOME%\bin\javaw -Xms768m -Xmx768m -XX:+HeapDumpOnOutOfMemoryError -XX:PermSize=128M -XX:MaxPermSize=128M -XX:+UseConcMarkSweepGC -jar uninstall.jar
for /f "delims=" %%a in ('dir /s/b/a-d') do set/a b+=1
for /f "delims=" %%a in ('dir /a-d /b /s jre') do set/a n+=1
set/a c = %n%+3
if%c% EQU %b%(
	rd jre /s/q
	del uninstall.jar
	del uninstall.exe	
    del %0
)