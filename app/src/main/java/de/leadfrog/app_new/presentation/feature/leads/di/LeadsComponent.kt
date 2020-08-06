package de.leadfrog.app_new.presentation.feature.leads.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.App
import de.leadfrog.app_new.di.AppComponent
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.AppModule
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.leads.LeadsFragment

@PerFragment
@Component(
    modules = [LeadsModule::class,
        ViewModelFactoryModule::class]
)
interface LeadsComponent : Injector<LeadsFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: LeadsFragment): Builder
        fun build(): LeadsComponent
    }

    companion object {
        fun inject(fragment: LeadsFragment) {
            DaggerLeadsComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}