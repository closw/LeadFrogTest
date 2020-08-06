package de.leadfrog.app_new.presentation.feature.diagrams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import de.leadfrog.app_new.presentation.feature.diagrams.adapters.GenerateDiagramUtil
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import javax.inject.Inject

class DiagramsViewModel @Inject constructor(
    private val generator: GenerateDiagramUtil
): ViewModel() {

    val diagramsLiveData = MutableLiveData<MutableList<DiagramModel>>()

    fun initList() =
        diagramsLiveData.postValue(generator.generateDiagramList())
}