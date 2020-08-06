package de.leadfrog.app_new.presentation.feature.logout.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.logout.LogoutFragment

@PerFragment
@Component(
    modules = [LogoutModule::class,
        ViewModelFactoryModule::class]
)
interface LogoutComponent : Injector<LogoutFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: LogoutFragment): Builder
        fun build(): LogoutComponent
    }

    companion object {
        fun inject(fragment: LogoutFragment) {
            DaggerLogoutComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}