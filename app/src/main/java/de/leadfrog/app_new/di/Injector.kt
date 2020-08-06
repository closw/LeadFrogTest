package de.leadfrog.app_new.di

interface Injector<in T> {
    fun inject(target: T)
}