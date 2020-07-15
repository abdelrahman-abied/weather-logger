# weather-logger
### Description

user can see current weather and weekly weather forecast 


## Optional Requirements:

● UI layout optimized for both Phone and Tablets screens

● Implement ‘More details’ screen (with ability to view more detailed information about weather
data returned from API)


# Technology used

## By using
* Kotlin
* MVVM
* Retrofit 2
* Material Design
* Room Database

## Libraries

```bash
apply plugin: 'kotlin-android-extensions'

```
```bash
    lementation 'androidx.recyclerview:recyclerview:1.1.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.google.android.material:material:1.1.0'
```    
```bash  
    //ViewModel and LiveData
    // Saved state module for ViewModel
    
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
       implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    kapt "androidx.lifecycle:lifecycle-compiler:2.2.0"
    androidTestImplementation "androidx.arch.core:core-testing:2.1.0"v

    // Livedata - Kotlin Flow
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'


    //Recyclerview & ConstraintLayout
    implementation 'androidx.constraintlayout:constraintlayout:2.0.0-beta6'

    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.5.0"

     //Moshi
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'

    
// RoomDB
    implementation "androidx.work:work-runtime-ktx:2.3.0"
    implementation "androidx.room:room-ktx:2.2.3"
    kapt "androidx.room:room-compiler:2.2.3"
    androidTestImplementation "androidx.room:room-testing:2.2.3"
```


```bash
