set JAVA_HOME=D:\programme\java\jdk-25
set PATH_TO_FX=D:/programme/java/javafx-sdk-25/lib

set APP_JAR=G:\intellij\JFoenux\demo\target\demo-1.0-SNAPSHOT.jar
set CLASSPATH=G:\repository\com\jfonux\jfonux\1.0.0-SNAPSHOT\jfonux-1.0.0-SNAPSHOT.jar;G:\intellij\JFoenux\demo\target\demo-1.0-SNAPSHOT.jar
set JAVA_CMD=%JAVA_HOME%\bin\java

rem ** JAVA FX PATH **
set JAVA_CMD=%JAVA_CMD% --module-path %PATH_TO_FX%

rem ** MODULES **
set JAVA_CMD=%JAVA_CMD% --add-modules java.se,javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

rem ** JAVA EXPORTS **
set JAVA_CMD=%JAVA_CMD% --add-exports javafx.base/com.sun.javafx.event=ALL-UNNAMED
set JAVA_CMD=%JAVA_CMD% --add-exports javafx.base/com.sun.javafx.reflect=ALL-UNNAMED
set JAVA_CMD=%JAVA_CMD% --add-exports javafx.base/com.sun.javafx.beans=ALL-UNNAMED
set JAVA_CMD=%JAVA_CMD% --add-exports javafx.graphics/com.sun.javafx.util=ALL-UNNAMED
set JAVA_CMD=%JAVA_CMD% --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED

set JAVA_CMD=%JAVA_CMD% --enable-native-access=javafx.graphics
set JAVA_CMD=%JAVA_CMD% --enable-native-access=javafx.web
set JAVA_CMD=%JAVA_CMD% -cp %CLASSPATH%

%JAVA_CMD% com.jfoenux.demo.MainApp