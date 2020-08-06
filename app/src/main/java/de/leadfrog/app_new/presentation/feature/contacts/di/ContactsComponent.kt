package de.leadfrog.app_new.presentation.feature.contacts.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.di.module.ViewModelFactoryModule
import de.leadfrog.app_new.presentation.feature.contacts.ContactsFragment

@PerFragment
@Component(
    modules = [ContactsModule::class,
        ViewModelFactoryModule::class]
)
interface ContactsComponent : Injector<ContactsFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(mContext: Context): Builder
        @BindsInstance
        fun fragment(mTarget: ContactsFragment): Builder
        fun build(): ContactsComponent
    }

    companion object {
        fun inject(fragment: ContactsFragment) {
            DaggerContactsComponent.builder()
                .context(fragment.requireContext())
                .fragment(fragment)
                .build()
                .inject(fragment)
        }
    }
}