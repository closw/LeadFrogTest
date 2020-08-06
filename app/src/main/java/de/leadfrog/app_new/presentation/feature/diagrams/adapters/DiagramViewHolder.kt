package de.leadfrog.app_new.presentation.feature.diagrams.adapters
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.ValueFormatter
import de.leadfrog.app_new.R
import de.leadfrog.app_new.presentation.base.ItemClickListener
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import kotlin.math.roundToInt

class DiagramViewHolder(itemView: View, private val listener : ItemClickListener<DiagramModel>) : RecyclerView.ViewHolder(itemView) {
    var barDiagram: BarChart = itemView.findViewById(R.id.barChart)
    var pieDiagram: PieChart = itemView.findViewById(R.id.pieChart)
    var lineDiagram: LineChart = itemView.findViewById(R.id.lineChart)
    var seeDetails : TextView = itemView.findViewById(R.id.see_details)

    fun bind (data : DiagramModel){
        seeDetails.setOnClickListener { listener.click(data) }
        when{
            data.barData != null -> {
                pieDiagram.visibility = GONE
                lineDiagram.visibility = GONE
                barDiagram.visibility = VISIBLE
                val groupSpace = 0.8f
                val barSpace = 0.1f
                barDiagram.data = data.barData
                barDiagram.groupBars(0f, groupSpace, barSpace)
                barDiagram.invalidate();
                barDiagram.isEnabled = false
            }
            data.lineData!= null ->{
                pieDiagram.visibility = GONE
                lineDiagram.visibility = VISIBLE
                barDiagram.visibility = GONE

                lineDiagram.data = data.lineData
                val quarters = arrayOf("Q1", "Q2", "Q3", "Q4")
                val formatter: ValueFormatter =
                    object : ValueFormatter() {
                        override fun getAxisLabel(value: Float, axis: AxisBase): String {
                            var index = value.roundToInt()
                            if(index == quarters.size) index--
                            if(index > quarters.size) index = quarters.size - 1
                            return quarters[index]
                        }
                    }
                val xAxis: XAxis = lineDiagram.xAxis
                xAxis.granularity = 1f // minimum axis-step (interval) is 1
                xAxis.valueFormatter = formatter
                lineDiagram.invalidate()
                lineDiagram.isEnabled = false
            }
            data.pieData != null ->{
                pieDiagram.visibility = VISIBLE
                lineDiagram.visibility = GONE
                barDiagram.visibility = GONE
                pieDiagram.data = data.pieData
                pieDiagram.invalidate()
                pieDiagram.isEnabled= false
            }

        }

    }

}