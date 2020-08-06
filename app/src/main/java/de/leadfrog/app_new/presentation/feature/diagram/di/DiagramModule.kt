package de.leadfrog.app_new.presentation.feature.diagram.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.feature.diagram.DiagramViewModel

@Module
class DiagramModule {

    @Provides
    @IntoMap
    @ViewModelKey(DiagramViewModel::class)
    fun provideViewModel(): ViewModel =
        DiagramViewModel()
}