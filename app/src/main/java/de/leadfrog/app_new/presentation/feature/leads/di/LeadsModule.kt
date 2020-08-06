package de.leadfrog.app_new.presentation.feature.leads.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.feature.leads.LeadsViewModel
import de.leadfrog.app_new.presentation.feature.leads.adapters.LeadsAdapter

@Module
class LeadsModule {

    @PerFragment
    @Provides
    @IntoMap
    @ViewModelKey(LeadsViewModel::class)
    fun provideViewModel(): ViewModel =
        LeadsViewModel()

    @PerFragment
    @Provides
    fun provideAdapter(): LeadsAdapter =
        LeadsAdapter()
}