package de.leadfrog.app_new.presentation.feature.rootcontainer.home

import android.content.Intent
import android.os.Bundle
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.BaseActivity
import de.leadfrog.app_new.presentation.base.type.PageTypes
import kotlinx.android.synthetic.main.activity_container_leads.*
import kotlinx.android.synthetic.main.content_container_home.*
import me.moallemi.multinavhost.navigation.TabManager


class HomeContainerActivity : BaseActivity() {

    private val tabManager: TabManager by lazy { TabManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_leads)
        setSupportActionBar(toolbar)

        bottomNavView.setOnNavigationItemSelectedListener{
            tabManager.switchTab(it.itemId)
            true
        }
        navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.drawer_nav_home -> drawerLayout.closeDrawers()
                R.id.drawer_nav_settings -> fireActivity(PageTypes.SettingsContainer)
                R.id.drawer_nav_help -> fireActivity(PageTypes.HelpContainer)
                R.id.drawer_nav_logout -> fireActivity(PageTypes.LogoutContainer)
            }
            true
        }

        if (savedInstanceState == null) {
            tabManager.currentController = tabManager.navHomeController
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }
}