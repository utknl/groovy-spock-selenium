# groovy-spock-selenium
Sauce Labs and Selenium demo using Spock framework.

Sauce Labs implementation will be added

## Prerequisites for using
```
1. Java
```

## How to Use 

1. clone the project

2. create 'driver' folder in project directory and paste [downloaded](http://chromedriver.chromium.org/downloads) chrome driver
   or change the driver path in Base.groovy 

3. open the project on terminal
   
3. type ```./gradlew clean test``` if this gives fail please try ```gradlew clean test```

4. enjoy

## How to Create

###### Note: I strongly recommend Intellij Idea for creating Gradle projects but if you love trouble in your life please follow:

1. download [gradle](https://gradle.org/)

2. create a directory, on directory path, type `gradle init --type java-library` on terminal
```text
   This will create all the package structure along with build.gradle
```

3. open the build.gradle and make the required changes as you wish (inspect my build.gradle file or just copy paste)

4. on terminal type ```./gradlew build``` or ```gradlew build``` and it's ready
