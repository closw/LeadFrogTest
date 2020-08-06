package de.leadfrog.app_new.presentation.feature.logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentLogoutBinding
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.feature.help.di.HelpComponent
import de.leadfrog.app_new.presentation.feature.logout.di.LogoutComponent
import javax.inject.Inject

class LogoutFragment : BaseFragment() {

    private lateinit var bindableView: FragmentLogoutBinding
    //region onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        bindableView =
            DataBindingUtil.inflate(inflater, R.layout.fragment_logout, container, false)
        return bindableView.root
    }
    //endregion

    @Inject
    lateinit var viewModel: LogoutViewModel

    override fun inject() {
        LogoutComponent.inject(this)
    }

    override fun initViews() {
        with(bindableView){
            viewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {
        //TODO("not implemented")
    }
}