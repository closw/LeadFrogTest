package de.leadfrog.app_new.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.App
import de.leadfrog.app_new.di.module.AppModule
import de.leadfrog.app_new.di.module.ComponentDependenciesModule
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ComponentDependenciesModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent: Injector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bind(app: App): Builder
        fun build(): AppComponent
    }
}