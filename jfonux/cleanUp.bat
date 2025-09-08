@echo off
echo cygwin: D:/cygwin64/bin
set PATH=%PATH%;D:/cygwin64/bin
echo root:   G:/intellij/JFoenux/jfonux
cd G:/intellij/JFoenux/jfonux
echo ** current branch **
git rev-parse --abbrev-ref HEAD
echo delete G:/intellij/JFoenux/jfonux/cleanUp.bat
start /b rm -f G:/intellij/JFoenux/jfonux/cleanUp.bat
