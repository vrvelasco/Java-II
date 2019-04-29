@echo off
 
set DERBY_HOME=C:\Applications\db-derby-10.14.1.0-bin
set JAVA_HOME=C:\Applications\zulu11.31.11-ca-jre11.0.3-win_x64
set NS_HOME=C:\Applications\1527\databases
set NS_PORT=1527

REM ---- do not edit below this line ----

REM Echo the user defined variables
REM ===
echo DERBY_HOME=%DERBY_HOME%
echo JAVA_HOME=%JAVA_HOME%
echo NS_HOME=%NS_HOME%
echo NS_PORT=%NS_PORT%

REM Set the shell PATH variable
REM ===
set PATH=%DERBY_HOME%\bin;%PATH%

REM Create the network server home if it doesn't exist
REM ===
md %NS_HOME% 2>NUL

REM Configure Derby networking so remote clients are allowed to connect
REM ===
set NS_HOST=0.0.0.0
echo NS_HOST=%NS_HOST%

REM Set Derby options
REM === 
set DERBY_OPTS=-Dderby.drda.host=%NS_HOST%
set DERBY_OPTS=%DERBY_OPTS% -Dderby.drda.portNumber=%NS_PORT%
set DERBY_OPTS=%DERBY_OPTS% -Dderby.system.home=%NS_HOME%
set DERBY_OPTS=%DERBY_OPTS% -Dderby.language.logStatementText=true

REM Start the network server
REM ===
startNetworkServer -noSecurityManager
