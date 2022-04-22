# CrossPlatformModule 
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/09d937b3dd2549aea7e304aedc050764)](https://www.codacy.com/gh/Monkey-Droid/CrossPlatformModule/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Monkey-Droid/CrossPlatformModule&amp;utm_campaign=Badge_Grade)

A Demo showing how to create a cross platform game on Android & Desktop using JMonkeyEngine. <br/>
Note : The project uses gradle 6.7.1, to support java-8 on android studio 4.2.0, you can upgrade to gradle-7.2.1 and use AGP-7 as you like.

# Modules : 

1) Game module `:game` : holds `build.gradle` dependencies for the game code & should hold your code.

2) Desktop module `:desktop` : holds `build.gradle` for desktop dependencies & implements the `:game` module, this module can hold the desktop gui.

3) Android module `:app` : holds `build.gradle` for the android dependencies & implements the `:game` module, this module can hold android dependent gui.

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

```bash
┌─[✗]─[twisted@parrot]─[~/AndroidStudioProjects/CrossPlatformModule]
└──╼ $./gradlew :app:installDebug

> Task :app:installDebug
Installing APK 'app-debug.apk' on 'Redmi Note 6 Pro - 10' for app:debug
Installed on 1 device.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/7.0.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 4s
33 actionable tasks: 1 executed, 32 up-to-date
```

# Building Game :

### Desktop : 
```bash
┌─[twisted@parrot]─[~/AndroidStudioProjects/CrossPlatformModule]
└──╼ $./gradlew :desktop:copyJars

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/7.0.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1s
5 actionable tasks: 5 up-to-date
┌─[twisted@parrot]─[~/AndroidStudioProjects/CrossPlatformModule]
└──╼ $./gradlew :desktop:releaseJar 

Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/7.0.2/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1s
6 actionable tasks: 6 up-to-date
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

=> Thanks Ali_RS for the suggestion of separating game module from desktop and android ones. <br/>
=> Thanks wizzardo for fixing creating jar from desktop issue. <br/>

## References : 

=> Android studio-AGP-Gradle release notes : 
https://developer.android.com/studio/releases/gradle-plugin

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
