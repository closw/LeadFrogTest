package de.leadfrog.app_new.di.module

import dagger.Binds
import dagger.Module
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.presentation.base.provider.IResourceProvider
import de.leadfrog.app_new.presentation.base.provider.ResourceProvider
import javax.inject.Singleton

@Module
abstract class ComponentDependenciesModule {
    @PerFragment
    @Binds
    abstract fun provideAndroidResource(source: ResourceProvider): IResourceProvider
}