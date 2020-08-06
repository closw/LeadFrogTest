package de.leadfrog.app_new.presentation.feature.diagrams.adapters

import android.content.Context
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import javax.inject.Inject
import kotlin.random.Random


class GenerateDiagramUtil @Inject constructor(
    private val context: Context
) {

    fun generateDiagramList(): MutableList<DiagramModel> {
        val diagramsList = mutableListOf<DiagramModel>()
        diagramsList.add(generatePieDataSet())
        diagramsList.add(generatePieDataSet())
        diagramsList.add(generateBarDataSet())
        diagramsList.add(generateBarDataSet())
        diagramsList.add(generateLineDataSet())
        diagramsList.add(generateLineDataSet())
        return diagramsList
    }

    private fun generateLineDataSet(): DiagramModel {
        val valsComp1 = mutableListOf<Entry>()
        val valsComp2 = mutableListOf<Entry>()
        for (i in 0..10) {
            val c1 =
                Entry(i.toFloat(), Random.nextDouble(50000.0, 150000.0).toFloat())
            valsComp1.add(c1)
            val c2 =
                Entry(i.toFloat(), Random.nextDouble(50000.0, 150000.0).toFloat())
            valsComp2.add(c2)
        }
        val setComp1 = LineDataSet(valsComp1, "Writers should be send")
        setComp1.axisDependency = YAxis.AxisDependency.LEFT
        setComp1.setColors(
            intArrayOf(android.R.color.holo_blue_bright),
            context
        )
        val setComp2 = LineDataSet(valsComp2, "Poets should be send")
        setComp2.setColors(
            intArrayOf(android.R.color.holo_red_light),
            context
        )
        setComp2.axisDependency = YAxis.AxisDependency.LEFT
        val dataSets = mutableListOf<ILineDataSet>()
        dataSets.add(setComp1)
        dataSets.add(setComp2)
        val data = LineData(dataSets)
        return DiagramModel().apply {
            lineData = data
        }
    }

    private fun generateBarDataSet(): DiagramModel {
        val entriesGroup1 = mutableListOf<BarEntry>()
        val entriesGroup2 = mutableListOf<BarEntry>()
        for (i in 0..60) {
            val c1 =
                BarEntry(i.toFloat(), Random.nextDouble(15.0, 100.0).toFloat())
            entriesGroup1.add(c1)
            val c2 =
                BarEntry(i.toFloat(), Random.nextDouble(20.0, 80.0).toFloat())
            entriesGroup2.add(c2)
        }
        val set1 = BarDataSet(entriesGroup1, "Count")
        set1.setColors(
            intArrayOf(android.R.color.holo_orange_dark),
            context
        )
        val set2 = BarDataSet(entriesGroup2, "Quality")
        set2.setColors(
            intArrayOf(android.R.color.holo_green_dark),
            context
        )
        val barWidth = 1.35f
        val data = BarData(set1, set2)
        data.barWidth = barWidth
        return DiagramModel().apply {
            barData = data
        }

    }

    fun generatePieDataSet(): DiagramModel {
        val per100 = 100.0f
        val per1 = Random.nextDouble(50.0, 100.0).toFloat()
        var nextPer = per100 - per1
        val per2 = (nextPer) - Random.nextDouble(
            0.0,
            (nextPer).toDouble()
        ).toFloat()
        nextPer -= per2
        val per3 = (nextPer) - Random.nextDouble(
            0.0,
            (nextPer).toDouble()
        ).toFloat()
        nextPer -= per3
        val per4 = nextPer

        val entries: MutableList<PieEntry> = mutableListOf()
        entries.add(PieEntry(per1, "Green"))
        entries.add(PieEntry(per2, "Yellow"))
        entries.add(PieEntry(per3, "Red"))
        entries.add(PieEntry(per4, "Blue"))
        val set = PieDataSet(entries, "Favorite color")
        set.setColors(
            intArrayOf(
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light,
                android.R.color.holo_blue_dark
            ),
            context
        )
        val data = PieData(set)
        return DiagramModel().apply {
            pieData = data
        }
    }
}