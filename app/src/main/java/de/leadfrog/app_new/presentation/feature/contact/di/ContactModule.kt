package de.leadfrog.app_new.presentation.feature.contact.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.feature.contact.ContactViewModel

@Module
class ContactModule {
    @PerFragment
    @Provides
    @IntoMap
    @ViewModelKey(ContactViewModel::class)
    fun provideViewModel(): ViewModel =
        ContactViewModel()
}