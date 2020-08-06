package de.leadfrog.app_new.presentation.feature.diagrams.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ComponentDependenciesModule
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.diagrams.DiagramsFragment

@PerFragment
@Component(
    modules = [ComponentDependenciesModule::class,
        DiagramsModule::class,
        ViewModelFactoryModule::class]
)
interface DiagramsComponent : Injector<DiagramsFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: DiagramsFragment): Builder
        fun build(): DiagramsComponent
    }

    companion object {
        fun inject(fragment: DiagramsFragment) {
            DaggerDiagramsComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}