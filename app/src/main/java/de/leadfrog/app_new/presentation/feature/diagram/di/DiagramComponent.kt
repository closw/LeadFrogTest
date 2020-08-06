package de.leadfrog.app_new.presentation.feature.diagram.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.diagram.DiagramFragment

@PerFragment
@Component(
    modules = [DiagramModule::class,
        ViewModelFactoryModule::class]
)
interface DiagramComponent : Injector<DiagramFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: DiagramFragment): Builder
        fun build(): DiagramComponent
    }

    companion object {
        fun inject(fragment: DiagramFragment) {
            DaggerDiagramComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}