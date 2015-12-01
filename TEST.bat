@echo off 
call RUN.bat 
(echo %ERRORLEVEL%) 

call RUN.bat -h 
(echo %ERRORLEVEL%) 

call RUN.bat -login XXX -pass XXX 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass XXX 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role XXX -res a.b 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res XXX 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role WRITE -res a 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role WRITE -res a.bc 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100 
(echo %ERRORLEVEL%) 

call RUN.bat -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX 
(echo %ERRORLEVEL%) 

pause