package de.leadfrog.app_new.presentation.feature.settings.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.base.provider.IResourceProvider
import de.leadfrog.app_new.presentation.feature.settings.SettingsViewModel

@Module
class SettingsModule {
    @Provides
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun provideViewModel(): ViewModel =
        SettingsViewModel()
}