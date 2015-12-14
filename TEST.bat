@echo off
call RUN.bat
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (
echo %ERRORLEVEL% instead of 0
)

call RUN.bat -h
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (echo %ERRORLEVEL% instead of 0)

call RUN.bat -login XXX -pass XXX
IF %ERRORLEVEL% EQU 1 (echo OK) ELSE (echo %ERRORLEVEL% instead of 1)

call RUN.bat -login jdoe  -pass XXX
IF %ERRORLEVEL% EQU 2 (echo OK) ELSE (echo %ERRORLEVEL% instead of 2)

call RUN.bat -login jdoe  -pass sup3rpaZZ
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (echo %ERRORLEVEL% instead of 0)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res a
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (echo %ERRORLEVEL% instead of 0)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res a.b
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (echo %ERRORLEVEL% instead of 0)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role XXX -res a.b
IF %ERRORLEVEL% EQU 3 (echo OK) ELSE (echo %ERRORLEVEL% instead of 3)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res XXX
IF %ERRORLEVEL% EQU 4 (echo OK) ELSE (echo %ERRORLEVEL% instead of 4)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role WRITE -res a
IF %ERRORLEVEL% EQU 4 (echo OK) ELSE (echo %ERRORLEVEL% instead of 4)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role WRITE -res a.bc
IF %ERRORLEVEL% EQU 4 (echo OK) ELSE (echo %ERRORLEVEL% instead of 4)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100
IF %ERRORLEVEL% EQU 0 (echo OK) ELSE (echo %ERRORLEVEL% instead of 0)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100
IF %ERRORLEVEL% EQU 5 (echo OK) ELSE (echo %ERRORLEVEL% instead of 5)

call RUN.bat -login jdoe  -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX
IF %ERRORLEVEL% EQU 5 (echo OK) ELSE (echo %ERRORLEVEL% instead of 5)

pause