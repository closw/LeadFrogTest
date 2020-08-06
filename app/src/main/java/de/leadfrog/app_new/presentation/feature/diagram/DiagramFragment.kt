package de.leadfrog.app_new.presentation.feature.diagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.ValueFormatter
import de.leadfrog.app_new.R
import de.leadfrog.app_new.databinding.FragmentDiagramBinding
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import de.leadfrog.app_new.presentation.base.BaseFragment
import de.leadfrog.app_new.presentation.feature.diagram.di.DiagramComponent
import de.leadfrog.app_new.presentation.feature.rootcontainer.home.HomeContainerViewModel
import javax.inject.Inject
import kotlin.math.roundToInt


class DiagramFragment() : BaseFragment() {
    private lateinit var binding: FragmentDiagramBinding

    //region CreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diagram, container, false)
        return binding.root
    }
    //endregion

    @Inject
    lateinit var viewModel: DiagramViewModel

    lateinit var pieDiagram: PieChart
    lateinit var lineDiagram: LineChart
    lateinit var barDiagram: BarChart
    lateinit var diagram: DiagramModel

    override fun inject() {
        DiagramComponent.inject(this)
    }

    override fun initViews() {
        with(binding) {
            viewModel = this@DiagramFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun initDisplayableData(view: View) {
        diagram = HomeContainerViewModel.diagram
        drawDiagram()
    }


    private fun drawDiagram() {
        pieDiagram = binding.pieChart
        lineDiagram = binding.lineChart
        barDiagram = binding.barChart
        when {
            diagram.barData != null -> {
                pieDiagram.visibility = View.GONE
                lineDiagram.visibility = View.GONE
                barDiagram.visibility = View.VISIBLE
                val groupSpace = 0.8f
                val barSpace = 0.1f
                with(barDiagram)
                {
                    data = diagram.barData
                    groupBars(0f, groupSpace, barSpace)
                    invalidate()
                }
            }
            diagram.lineData != null -> {
                pieDiagram.visibility = View.GONE
                lineDiagram.visibility = View.VISIBLE
                barDiagram.visibility = View.GONE

                lineDiagram.data = diagram.lineData
                val quarters = arrayOf("Q1", "Q2", "Q3", "Q4")
                val formatter: ValueFormatter =
                    object : ValueFormatter() {
                        override fun getAxisLabel(value: Float, axis: AxisBase): String {
                            var index = value.roundToInt()
                            if (index == quarters.size) index--
                            if (index > quarters.size) index = quarters.size - 1
                            return quarters[index]
                        }
                    }
                val xAxis: XAxis = lineDiagram.xAxis
                xAxis.granularity = 1f // minimum axis-step (interval) is 1
                xAxis.valueFormatter = formatter
                lineDiagram.invalidate()
            }
            diagram.pieData != null -> {
                pieDiagram.visibility = View.VISIBLE
                lineDiagram.visibility = View.GONE
                barDiagram.visibility = View.GONE
                pieDiagram.data = diagram.pieData
                pieDiagram.invalidate()
            }

        }
    }
}