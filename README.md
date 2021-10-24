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

### Android : 
```gradle
./gradlew :app:assemble
```

References : 

https://developer.android.com/studio/build/building-cmdline
