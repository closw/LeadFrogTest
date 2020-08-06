package de.leadfrog.app_new.presentation.base

import android.content.Context
import android.content.Intent
import de.leadfrog.app_new.presentation.base.type.PageTypes
import de.leadfrog.app_new.presentation.feature.rootcontainer.HelpContainerActivity
import de.leadfrog.app_new.presentation.feature.rootcontainer.LogoutContainerActivity
import de.leadfrog.app_new.presentation.feature.rootcontainer.SettingsContainerActivity
import de.leadfrog.app_new.presentation.feature.rootcontainer.home.HomeContainerActivity
import javax.inject.Inject

class ActivityNavigationManager @Inject constructor() {
    companion object {
        fun getInstance(): ActivityNavigationManager = ActivityNavigationManager()
    }

    lateinit var currentPage: PageTypes
    private var pageContext: Context? = null

    fun Navigate(page: PageTypes, context: Context) {
        pageContext = context
        navigate(page)
    }

    private fun navigate(page: PageTypes) {
        currentPage = page
        when (page) {
            PageTypes.HomeContainer -> pageContext?.startActivity(
                Intent(
                    pageContext,
                    HomeContainerActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            PageTypes.SettingsContainer -> pageContext?.startActivity(
                Intent(
                    pageContext,
                    SettingsContainerActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            PageTypes.HelpContainer -> pageContext?.startActivity(
                Intent(
                    pageContext,
                    HelpContainerActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            PageTypes.LogoutContainer -> pageContext?.startActivity(
                Intent(
                    pageContext,
                    LogoutContainerActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        }
    }
}