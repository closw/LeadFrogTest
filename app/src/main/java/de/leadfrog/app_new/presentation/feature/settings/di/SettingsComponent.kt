package de.leadfrog.app_new.presentation.feature.settings.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.settings.SettingsFragment

@PerFragment
@Component(
    modules = [SettingsModule::class,
        ViewModelFactoryModule::class]
)
interface SettingsComponent : Injector<SettingsFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: SettingsFragment): Builder
        fun build(): SettingsComponent
    }

    companion object {
        fun inject(fragment: SettingsFragment) {
            DaggerSettingsComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}