package de.leadfrog.app_new.presentation.feature.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentSettingsBinding
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.feature.settings.di.SettingsComponent
import javax.inject.Inject

class SettingsFragment: BaseFragment() {

    private lateinit var bindableView: FragmentSettingsBinding
    //region onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        bindableView =
            DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        return bindableView.root
    }
    //endregion

    @Inject
    lateinit var viewModel: SettingsViewModel

    override fun inject() {
        SettingsComponent.inject(this)
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