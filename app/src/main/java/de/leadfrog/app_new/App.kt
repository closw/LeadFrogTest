package de.leadfrog.app_new

import android.app.Application
import de.leadfrog.app_new.di.AppComponent
import de.leadfrog.app_new.di.DaggerAppComponent
import de.leadfrog.app_new.di.module.AppModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .bind(this)
            .build()
            .inject(this)
    }
}