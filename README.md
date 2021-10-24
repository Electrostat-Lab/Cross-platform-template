# CrossPlatformModule

A Demo showing how to create a cross platform game on Android & Desktop using JMonkeyEngine.

# Features : 

1) Gradle.

2) A single assets res folder (gradle resource folder).

3) Android Support via `:app` module.

4) Desktop Support via `:desktop` module.

5) Jar building task & app assembly.

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

References : 

=> gradlew for android:
https://developer.android.com/studio/build/building-cmdline

=> Gradle DSL :

=> Gradle for java :

