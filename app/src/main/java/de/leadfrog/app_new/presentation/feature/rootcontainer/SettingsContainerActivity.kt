package de.leadfrog.app_new.presentation.feature.rootcontainer

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.BaseActivity
import de.leadfrog.app_new.presentation.base.type.PageTypes
import kotlinx.android.synthetic.main.activity_container_settings.*
import kotlinx.android.synthetic.main.content_container_settings.*

class SettingsContainerActivity: BaseActivity() {

    val navController: NavController
        get() = findNavController(R.id.navHostFragmentSettings)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_settings)
        setSupportActionBar(toolbarSettings)

        navViewSettings.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.drawer_nav_home -> fireActivity(PageTypes.HomeContainer)
                R.id.drawer_nav_settings -> drawerLayout.closeDrawers()
                R.id.drawer_nav_help -> fireActivity(PageTypes.HelpContainer)
                R.id.drawer_nav_logout -> fireActivity(PageTypes.LogoutContainer)
            }
            true
        }
    }
}