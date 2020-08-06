package de.leadfrog.app_new.presentation.feature.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentContactBinding
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.feature.contact.di.ContactComponent
import javax.inject.Inject

class ContactFragment : BaseFragment() {
    private lateinit var binding: FragmentContactBinding

    //region CreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)
        return binding.root
    }
    //endregion
    @Inject
    lateinit var viewModel: ContactViewModel

    private val args: ContactFragmentArgs by navArgs()

    override fun inject() {
        ContactComponent.inject(this)
    }

    override fun initViews() {
        with(binding) {
            contact = args.argContact
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {
        //TODO("not implemented")
    }
}