package de.leadfrog.app_new.presentation.feature.rootcontainer

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.BaseActivity
import de.leadfrog.app_new.presentation.base.type.PageTypes
import kotlinx.android.synthetic.main.activity_container_logout.*

class LogoutContainerActivity: BaseActivity() {

    val navController: NavController
        get() = findNavController(R.id.navHostFragmentLogout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_logout)

        navViewLogout.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.drawer_nav_home -> fireActivity(PageTypes.HomeContainer)
                R.id.drawer_nav_settings -> fireActivity(PageTypes.SettingsContainer)
                R.id.drawer_nav_help -> fireActivity(PageTypes.HelpContainer)
                R.id.drawer_nav_logout -> drawerLayout.closeDrawers()
            }
            true
        }
    }
}