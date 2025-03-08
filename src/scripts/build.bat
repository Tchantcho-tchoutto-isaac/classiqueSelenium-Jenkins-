@echo off
REM 
cd /d "%USERPROFILE%\Desktop\TP QA3\classique"  

REM 
if exist "%USERPROFILE%\Desktop\TP QA3\classique" (
    echo Accès au projet valide, exécution des tests...
    powershell -NoExit -Command "cd '%USERPROFILE%\Desktop\TP QA3\classique'; mvn clean test"
) else (
    echo Le chemin du projet est invalide. Vérifiez que le répertoire existe.
)

pause
