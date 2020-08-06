package de.leadfrog.app_new.presentation.feature.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentHelpBinding
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.feature.contact.di.ContactComponent
import de.leadfrog.app_new.presentation.feature.help.di.HelpComponent
import javax.inject.Inject

class HelpFragment: BaseFragment() {

    private lateinit var bindableView: FragmentHelpBinding
    //region onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        bindableView =
            DataBindingUtil.inflate(inflater, R.layout.fragment_help, container, false)
        return bindableView.root
    }
    //endregion

    @Inject
    lateinit var viewModel: HelpViewModel

    override fun inject() {
        HelpComponent.inject(this)
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