package de.leadfrog.app_new.presentation.viewmodel

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.PieData

data class DiagramModel(
    var lineData : LineData? = null,
    var barData : BarData? = null,
    var pieData : PieData? = null
)