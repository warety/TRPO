
mkdir workAP

if [ "$(uname)" == "Darwin" ]; then
    echo MacOS
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    echo Linux
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ]; then
    echo Windows
fi

javac -classpath commons-cli-1.3.1.jar -sourcepath src -d workAP src/*.java
jar -cfe AAAproj.jar Main -C workAP .