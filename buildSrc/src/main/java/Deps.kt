object KotlinDeps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object JetpackDeps{
    const val material = "com.google.android.material:material:${Versions.material}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val diagrams = "com.github.PhilJay:MPAndroidChart:${Versions.DIAGRAMS}"
}

object GlideDeps{
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideToVector = "com.github.corouteam:GlideToVectorYou:${Versions.glideToVectorYou}"
}

object NetworkDeps{
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val adapterRx = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
}

object RoomDeps{
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val rxJava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
}

object DaggerDeps{
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object RxDeps{
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxkotlin}"
}

object TestDeps{
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ANDROID_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ANDROID_ESPRESSO}"
}

object CoreDeps{
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val recycler = "androidx.recyclerview:recyclerview:${Versions.RECYCLER}"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH}"
}
