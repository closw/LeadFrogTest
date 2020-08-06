package de.leadfrog.app_new.presentation.feature.rootcontainer

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.BaseActivity
import de.leadfrog.app_new.presentation.base.type.PageTypes
import kotlinx.android.synthetic.main.activity_container_help.*

class HelpContainerActivity: BaseActivity() {

    val navController: NavController
        get() = findNavController(R.id.navHostFragmentHelp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_help)

        navViewHelp.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.drawer_nav_home -> fireActivity(PageTypes.HomeContainer)
                R.id.drawer_nav_settings -> fireActivity(PageTypes.SettingsContainer)
                R.id.drawer_nav_help -> drawerLayout.closeDrawers()
                R.id.drawer_nav_logout -> fireActivity(PageTypes.LogoutContainer)
            }
            true
        }
    }
}