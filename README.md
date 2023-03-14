# Cross-platform-template 
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/09d937b3dd2549aea7e304aedc050764)](https://www.codacy.com/gh/Monkey-Droid/CrossPlatformModule/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Monkey-Droid/CrossPlatformModule&amp;utm_campaign=Badge_Grade)

A cross platform template for jMonkeyEngine games supporting both common-platform and platform-specific environment using gradle sub-projects.

# Modules : 
1) Game module `:game` : holds `build.gradle` dependencies for the game code & should hold your code.
2) Game-assets module `:game-assets`: holds game assets at `./game-assets/src/main/resources` and supports java code specific to loading assets which is also a cross-platform module.
3) Desktop module `:desktop` : holds `build.gradle` for desktop dependencies and implements the `:game` module and the `game-assets` module, this module can hold the desktop dependent gui and hardware code.
4) Android module `:android` : holds `build.gradle` for the android dependencies and implements the `:game` module and the `game-assets` module, this module can hold android dependent gui and hardware code.

# Features : 
- [x] A platform independent assets module `:game-assets` for game assets.
- [x] A platform independent game module `:game` for game logic.
- [x] Android Support via `:android` module.
- [x] Desktop Support via `:desktop` module.
- [x] Desktop executable jar building task.
- [x] Automate game building using gradle tasks via GitHub CI.
- [ ] Automate game releasing `on-release` via GitHub CI `on-release` action.
- [ ] Android emulator and adb helper tasks (wip).

# Running Game : 

### On Desktop : 

```gradle
./gradlew run
```

### On Android : 

Install the app on a connected device via adb.

```bash
┌─[✗]─[twisted@parrot]─[~/AndroidStudioProjects/CrossPlatformModule]
└──╼ $./gradlew :android:installDebug

> Task :app:installDebug
Installing APK 'app-debug.apk' on 'Redmi Note 6 Pro - 10' for app:debug
Installed on 1 device.

BUILD SUCCESSFUL in 4s
33 actionable tasks: 1 executed, 32 up-to-date
```

# Building Game :

### Desktop : 
```bash
$./gradlew :desktop:clean &&
 ./gradlew :desktop:build && 
 ./gradlew :desktop:copyJars && 
 ./gradlew :desktop:releaseJar 
```
![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/desktop/Screenshot%20at%202021-10-25%2000-08-45.png)

### Android : 
```gradle
$./gradlew :android:clean &&
 ./gradlew :android:build && 
 ./gradlew :android:assemble
```
![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/android/Screenshot_20211025-000113671.jpg)

![](https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/android/Screenshot_20211025-000108283.jpg)

## Appendix: 

### Credits: 
=> Thanks [Ali_RS](https://hub.jmonkeyengine.org/u/ali_rs/summary) for the suggestion of separating game and game-assets module from desktop and android ones. <br/>
=> Thanks [wizzardo](https://hub.jmonkeyengine.org/u/wizzardo/summary) for fixing creating jar from desktop issue. <br/>

### References : 

=> [Android studio-AGP-Gradle release notes](https://developer.android.com/studio/releases/gradle-plugin)

=> [Gradle wrapper for android](https://developer.android.com/studio/build/building-cmdline)

=> [Gradle DSL](https://docs.gradle.org/current/dsl/index.html)

=> [Gradle multi-project-builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)

=> [Gradle/Groovy Udacity course by google](https://github.com/udacity/ud867/blob/master/1.11-Exercise-ConfigureFileSystemTasks/solution.gradle)

=> See JMonkeyEngine Android Examples: 
- [jme3-simple-examples](https://github.com/Scrappers-glitch/jme3-Simple-Examples)
- [DB-Training-App](https://github.com/Scrappers-glitch/DBTraining)
- [SEE-Demo](https://github.com/Scrappers-glitch/Superior-Extended-Engine/tree/master/demoApp)

=> See JMonkeyEngine RPI armhf Desktop Example: 
- [JmeCarPhysicsTestRPI](https://github.com/Scrappers-glitch/JmeCarPhysicsTestRPI)
- [GPIOJmeCarTest](https://github.com/Software-Hardware-Codesign/JmeCarPhysicsTestRPI/blob/master/src/main/java/GPIOJmeCarTest.java)

