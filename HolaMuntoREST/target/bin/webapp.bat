@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\mysql\mysql-connector-java\5.1.6\mysql-connector-java-5.1.6.jar;"%REPO%"\org\eclipse\persistence\org.eclipse.persistence.jpa\2.5.0-RC1\org.eclipse.persistence.jpa-2.5.0-RC1.jar;"%REPO%"\org\eclipse\persistence\javax.persistence\2.1.0-RC1\javax.persistence-2.1.0-RC1.jar;"%REPO%"\org\eclipse\persistence\org.eclipse.persistence.asm\2.5.0-RC1\org.eclipse.persistence.asm-2.5.0-RC1.jar;"%REPO%"\org\eclipse\persistence\org.eclipse.persistence.antlr\2.5.0-RC1\org.eclipse.persistence.antlr-2.5.0-RC1.jar;"%REPO%"\org\eclipse\persistence\org.eclipse.persistence.jpa.jpql\2.5.0-RC1\org.eclipse.persistence.jpa.jpql-2.5.0-RC1.jar;"%REPO%"\org\eclipse\persistence\org.eclipse.persistence.core\2.5.0-RC1\org.eclipse.persistence.core-2.5.0-RC1.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.4.4\jackson-databind-2.4.4.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.4.0\jackson-annotations-2.4.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.4.4\jackson-core-2.4.4.jar;"%REPO%"\org\eclipse\persistence\eclipselink\2.5.2\eclipselink-2.5.2.jar;"%REPO%"\org\eclipse\persistence\commonj.sdo\2.1.1\commonj.sdo-2.1.1.jar;"%REPO%"\org\webjars\jquery\2.1.4\jquery-2.1.4.jar;"%REPO%"\org\glassfish\extras\glassfish-embedded-web\3.1.1\glassfish-embedded-web-3.1.1.jar;"%REPO%"\com\sun\jersey\jersey-server\1.19.4\jersey-server-1.19.4.jar;"%REPO%"\com\sun\jersey\jersey-core\1.19.4\jersey-core-1.19.4.jar;"%REPO%"\javax\ws\rs\jsr311-api\1.1.1\jsr311-api-1.1.1.jar;"%REPO%"\edu\sergioArboleda\holamuntorest\holaMundo\1.0-SNAPSHOT\holaMundo-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" MainGlassfish %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
