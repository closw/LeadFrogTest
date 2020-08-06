package de.leadfrog.app_new.presentation.feature.logout.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.base.provider.IResourceProvider
import de.leadfrog.app_new.presentation.feature.logout.LogoutViewModel
import de.leadfrog.app_new.presentation.feature.settings.SettingsViewModel

@Module
class LogoutModule {
    @Provides
    @IntoMap
    @ViewModelKey(LogoutViewModel::class)
    fun provideViewModel(): ViewModel =
        LogoutViewModel()
}