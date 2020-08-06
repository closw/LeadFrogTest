package de.leadfrog.app_new.presentation.feature.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentContactsBinding
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.feature.contacts.adapters.ContactsAdapter
import de.leadfrog.app_new.presentation.feature.contacts.di.ContactsComponent
import de.leadfrog.app_new.presentation.feature.leads.LeadsFragmentDirections
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import javax.inject.Inject

class ContactsFragment: ItemClickListener<ContactModel>, BaseFragment() {
    private lateinit var binding: FragmentContactsBinding
    //region CreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, container, false)
        return binding.root
    }
    //endregion

    @Inject
    lateinit var adapter: ContactsAdapter

    @Inject
    lateinit var viewModel: ContactsViewModel

    override fun inject() {
        ContactsComponent.inject(this)
    }

    override fun initViews() {
        adapter.listener = this
        with(binding) {
            contactsList.adapter = this@ContactsFragment.adapter
            viewModel = this@ContactsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {

        viewModel.contactsLiveData.observe(
            viewLifecycleOwner,
            Observer {
                adapter.setList(it)
            }
        )
        viewModel.initList()
    }

    override fun click(item: ContactModel) {
        directionNavigate(ContactsFragmentDirections.actionToContactFragment(item))
    }
}