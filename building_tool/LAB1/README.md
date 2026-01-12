

### LAB1  Java Application Build with Gradle
This project demonstrates how to build, test, and package a Java application using **Gradle** on a Linux environment (WSL).

### Commands
sudo apt update
sudo apt install gradle -y
gradle -v

git clone https://github.com/Ibrahim-Adel15/build1.git
cd build1

gradle test
gradle build

java -jar build/libs/ivolve-app.jar
curl http://localhost:8080

cd ..

### Build Success
![Build](build.jpg)

### Application Running
![Run](lab1.jpg)	



