@echo off 
set var1=0 
call RUN.bat 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -h 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 
call RUN.bat -login XXX -pass XXX 
IF %ERRORLEVEL% EQU 1 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass XXX 
IF %ERRORLEVEL% EQU 2 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role XXX -res a.b 
IF %ERRORLEVEL% EQU 3 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res XXX 
IF %ERRORLEVEL% EQU 4 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role WRITE -res a 
IF %ERRORLEVEL% EQU 4 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role WRITE -res a.bc 
IF %ERRORLEVEL% EQU 4 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100 
IF %ERRORLEVEL% EQU 0 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100 
IF %ERRORLEVEL% EQU 5 (set /a var1+=0) ELSE (set /a var1=1) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX 
IF %ERRORLEVEL% EQU 5 (set /a var1+=0) ELSE (set /a var1=1) 

echo %var1% 

pause
