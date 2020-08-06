package de.leadfrog.app_new.presentation.feature.diagrams.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import de.leadfrog.app_new.R
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.ViewModelKey
import de.leadfrog.app_new.presentation.feature.diagrams.DiagramsFragment
import de.leadfrog.app_new.presentation.feature.diagrams.DiagramsViewModel
import de.leadfrog.app_new.presentation.feature.diagrams.adapters.DiagramsAdapter
import de.leadfrog.app_new.presentation.feature.diagrams.adapters.GenerateDiagramUtil

@Module
class DiagramsModule {

    @PerFragment
    @Provides
    fun provideDiagramsList(
        context: Context
    ) = GenerateDiagramUtil(context)

    @PerFragment
    @Provides
    fun provideManager(context: Context): RecyclerView.LayoutManager = GridLayoutManager(context, 2)

    @PerFragment
    @Provides
    @IntoMap
    @ViewModelKey(DiagramsViewModel::class)
    fun provideViewModel(
        generator: GenerateDiagramUtil
    ): ViewModel =
        DiagramsViewModel(generator)

    @PerFragment
    @Provides
    fun provideAdapter(): DiagramsAdapter =
        DiagramsAdapter()
}