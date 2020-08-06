package de.leadfrog.app_new.presentation.feature.help.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.help.HelpFragment
import de.leadfrog.app_new.presentation.feature.leads.LeadsFragment
import de.leadfrog.app_new.presentation.feature.leads.di.DaggerLeadsComponent
import de.leadfrog.app_new.presentation.feature.leads.di.LeadsModule

@PerFragment
@Component(
    modules = [HelpModule::class,
        ViewModelFactoryModule::class]
)
interface HelpComponent : Injector<HelpFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: HelpFragment): Builder
        fun build(): HelpComponent
    }

    companion object {
        fun inject(fragment: HelpFragment) {
            DaggerHelpComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}