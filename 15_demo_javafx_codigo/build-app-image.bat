@echo off
setlocal
cd /d %~dp0
call mvn -DskipTests clean package
call jpackage --type app-image --input target --dest dist --name AdminPatternsLab --main-jar javafx-admin-patterns-lab-0.1.0.jar --main-class com.kaf.lab.LabApplication
endlocal
