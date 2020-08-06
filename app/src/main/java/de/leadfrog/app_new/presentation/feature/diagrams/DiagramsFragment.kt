package de.leadfrog.app_new.presentation.feature.diagrams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentDiagramsBinding
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.feature.diagrams.di.DiagramsComponent
import de.leadfrog.app_new.presentation.feature.diagrams.adapters.DiagramsAdapter
import de.leadfrog.app_new.presentation.feature.rootcontainer.home.HomeContainerViewModel
import javax.inject.Inject
import javax.inject.Provider

class DiagramsFragment : ItemClickListener<DiagramModel>, BaseFragment() {
    private lateinit var binding: FragmentDiagramsBinding

    //region CreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_diagrams, container, false)
        return binding.root
    }
    //endregion

    @Inject
    lateinit var viewModel: DiagramsViewModel

    @Inject
    lateinit var adapter: DiagramsAdapter

    @Inject
    lateinit var layoutManager: Provider<RecyclerView.LayoutManager>

    override fun onResume() {
        super.onResume()
        viewModel.initList()
    }

    override fun inject() {
        DiagramsComponent.inject(this)
    }

    override fun initViews() {
        adapter.listener = this
        with(binding) {
            with(statisticList) {
                this.layoutManager = GridLayoutManager(context, 2)
                this.adapter = this@DiagramsFragment.adapter
            }
            this.viewModel = this@DiagramsFragment.viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {
        viewModel.diagramsLiveData.observe(
            viewLifecycleOwner,
            Observer {
                adapter.setList(it)
            }
        )
        viewModel.initList()
    }

    override fun click(item: DiagramModel) {
        HomeContainerViewModel.diagram = item
        fragmentNavigate(R.id.action_to_diagramFragment)
    }
}