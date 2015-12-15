
rm -r  workAP
rm AAAproj.jar
export PATH=$PATH:"/c/Program Files/Java/jdk1.7.0_79/bin"
mkdir workAP


javac -classpath commons-cli-1.3.1.jar -sourcepath src -d workAP src/*.java
jar -cfe AAAproj.jar Main -C workAP .