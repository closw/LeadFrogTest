package de.leadfrog.app_new.presentation.feature.leads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentLeadsBinding
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.feature.leads.adapters.LeadsAdapter
import de.leadfrog.app_new.presentation.feature.leads.di.LeadsComponent
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.viewmodel.LeadModel
import javax.inject.Inject

class LeadsFragment: ItemClickListener<ContactModel>, BaseFragment() {

    companion object {
        fun getInstance(): Fragment = LeadsFragment()
    }

    private lateinit var binding: FragmentLeadsBinding

    //region CreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_leads, container, false)
        return binding.root
    }
    //endregion

    @Inject
    lateinit var adapter: LeadsAdapter

    @Inject
    lateinit var viewModel: LeadsViewModel

    override fun inject() {
        LeadsComponent.inject(this)
    }

    override fun initViews() {
        adapter.listener = this
        with(binding) {
            leadsList.adapter = this@LeadsFragment.adapter
            viewModel = this@LeadsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {

        viewModel.leadsLiveData.observe(
            viewLifecycleOwner,
            Observer {
                adapter.setList(it)
            }
        )
        viewModel.initList()
    }

    override fun click(item: ContactModel) {
        directionNavigate(LeadsFragmentDirections.actionToLeadFragment(item))
    }
}