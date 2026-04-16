@echo off
setlocal
cd /d %~dp0
call mvn javafx:run
endlocal
