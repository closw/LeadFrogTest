package de.leadfrog.app_new.presentation.feature.contact.di

import dagger.BindsInstance
import dagger.Component
import de.leadfrog.app_new.App
import de.leadfrog.app_new.di.AppComponent
import de.leadfrog.app_new.di.Injector
import de.leadfrog.app_new.di.PerFragment
import de.leadfrog.app_new.presentation.feature.contact.ContactFragment


@PerFragment
@Component(
    modules = [ContactModule::class]
)
interface ContactComponent : Injector<ContactFragment> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(mTarget: ContactFragment): Builder
        fun build(): ContactComponent
    }

    companion object {
        fun inject(fragment: ContactFragment) {
            DaggerContactComponent.builder()
                .fragment(fragment)
                .build()
        }
    }
}