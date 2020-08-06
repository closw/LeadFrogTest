package me.moallemi.multinavhost.navigation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.feature.rootcontainer.home.HomeContainerActivity
import kotlinx.android.synthetic.main.content_container_home.*

class TabManager(private val mainActivity: HomeContainerActivity) {

    private val startDestinations = mapOf(
            R.id.bottom_nav_leads to R.id.leadsFragment,
            R.id.bottom_nav_contacts to R.id.contactsFragment,
            R.id.bottom_nav_statistics to R.id.diagramsFragment
    )
    private var currentTabId: Int = R.id.bottom_nav_leads
    var currentController: NavController? = null
    private var tabHistory = TabHistory().apply { push(R.id.bottom_nav_leads) }

    val navHomeController: NavController by lazy {
        mainActivity.findNavController(R.id.leadsTab).apply {
            graph = navInflater.inflate(R.navigation.home_container_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.bottom_nav_leads)
            }
        }
    }
    private val navDashboardController: NavController by lazy {
        mainActivity.findNavController(R.id.contactsTab).apply {
            graph = navInflater.inflate(R.navigation.home_container_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.bottom_nav_contacts)
            }
        }
    }
    private val navNotificationsController: NavController by lazy {
        mainActivity.findNavController(R.id.statisticsTab).apply {
            graph = navInflater.inflate(R.navigation.home_container_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.bottom_nav_statistics)
            }
        }
    }

    private val homeTabContainer: View by lazy { mainActivity.leadsTabContainer }
    private val dashboardTabContainer: View by lazy { mainActivity.contactsTabContainer }
    private val notificationsTabContainer: View by lazy { mainActivity.statisticsTabContainer }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(KEY_TAB_HISTORY, tabHistory)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            tabHistory = it.getSerializable(KEY_TAB_HISTORY) as TabHistory

            switchTab(mainActivity.bottomNavView.selectedItemId, false)
        }
    }

    fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination == null || it.currentDestination?.id == startDestinations.getValue(currentTabId)) {
                if (tabHistory.size > 1) {
                    val tabId = tabHistory.popPrevious()
                    switchTab(tabId, false)
                    mainActivity.bottomNavView.menu.findItem(tabId)?.isChecked = true
                } else {
                    mainActivity.finish()
                }
            }
            it.popBackStack()
        } ?: run {
            mainActivity.finish()
        }
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        currentTabId = tabId

        when (tabId) {
            R.id.bottom_nav_leads -> {
                currentController = navHomeController
                invisibleTabContainerExcept(homeTabContainer)
            }
            R.id.bottom_nav_contacts -> {
                currentController = navDashboardController
                invisibleTabContainerExcept(dashboardTabContainer)
            }
            R.id.bottom_nav_statistics -> {
                currentController = navNotificationsController
                invisibleTabContainerExcept(notificationsTabContainer)
            }
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
    }

    private fun invisibleTabContainerExcept(container: View) {
        homeTabContainer.isInvisible = true
        dashboardTabContainer.isInvisible = true
        notificationsTabContainer.isInvisible = true

        container.isInvisible = false
    }

    companion object {
        private const val KEY_TAB_HISTORY = "key_tab_history"
    }
}