# CrossPlatformModule

A Demo showing how to create a cross platform game on Android & Desktop using JMonkeyEngine.

# Features : 

1) Gradle.

2) A single assets res folder (gradle resource folder).

3) Android Support via `:app` module.

4) Desktop Support via `:desktop` module.

5) Jar building task & app assembly.

# Running Game : 

### Desktop : 

```gradle
./gradlew run
```

### Android : 

Install the app on a connected device via adb.

```gradle
./gradlew :app:install
```

# Building Game :

### Desktop : 
```gradle
./gradlew :desktop:assemble
```
![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/desktop/Screenshot%20at%202021-10-25%2000-08-45.png)

### Android : 
```gradle
./gradlew :app:assemble
```
![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/android/Screenshot_20211025-000113671.jpg)

![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/android/Screenshot_20211025-000108283.jpg)

## In order to use : 

1) Through Android Studio, you can code for both the desktop & the android at the same time.

2) Command Line tools using git & gradlew commands.

=> Thanks Ali_RS for the suggestion of separating game module from desktop and android ones.
=> Thanks wizzardo for fixing creating jar from desktop issue.

References : 

=> gradlew for android:
https://developer.android.com/studio/build/building-cmdline

=> Gradle DSL : https://docs.gradle.org/current/dsl/index.html

=> Gradle for java : https://docs.gradle.org/current/userguide/multi_project_builds.html

=> Gradle/Groovy Udacity course by google : https://github.com/udacity/ud867/blob/master/1.11-Exercise-ConfigureFileSystemTasks/solution.gradle

=> See JMonkeyEngine Android Examples : https://github.com/Scrappers-glitch/jme3-Simple-Examples <br/>
https://github.com/Scrappers-glitch/DBTraining <br/>
https://github.com/Scrappers-glitch/Superior-Extended-Engine/tree/master/demoApp <br/>

=> See JMonkeyEngine Desktop Example : https://github.com/Scrappers-glitch/basic-gradle-template

=> See JMonkeyEngine RPI armhf Desktop Example : https://github.com/Scrappers-glitch/JmeCarPhysicsTestRPI
