package de.leadfrog.app_new.presentation.feature.contacts.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.feature.contacts.ContactsViewModel
import de.leadfrog.app_new.presentation.feature.contacts.adapters.ContactsAdapter

@Module
class ContactsModule {

    @PerFragment
    @Provides
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    fun provideViewModel(): ViewModel =
        ContactsViewModel()

    @PerFragment
    @Provides
    fun provideAdapter(): ContactsAdapter =
        ContactsAdapter()
}