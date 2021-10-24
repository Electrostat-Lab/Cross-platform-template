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
![]{https://github.com/Scrappers-glitch/CrossPlatformModule/blob/master/screenshots/desktop/Screenshot%20at%202021-10-25%2000-08-45.png}

### Android : 
```gradle
./gradlew :app:assemble
```

References : 

https://developer.android.com/studio/build/building-cmdline
