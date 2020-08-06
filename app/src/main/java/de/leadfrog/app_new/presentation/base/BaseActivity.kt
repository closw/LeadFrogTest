package de.leadfrog.app_new.presentation.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import de.leadfrog.app_new.presentation.base.type.PageTypes
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    private val activityNavigationManager = ActivityNavigationManager.getInstance()

    fun fireActivity(destination: PageTypes) {
        activityNavigationManager.Navigate(destination, this)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}