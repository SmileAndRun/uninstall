@echo off
echo BroadDirector Uninstall
java -jar uninstall.jar
set a = 0
for /f "delims=" %%a in ('dir /s/b/ad') do set/a a+=1
for /f "delims=" %%a in ('dir /s/b/a-d') do set/a b+=1
if %b% EQU  2 (
	del uninstall.jar
	del %0
)

