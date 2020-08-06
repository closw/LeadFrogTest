package de.leadfrog.app_new.presentation.feature.rootcontainer.home

import androidx.lifecycle.ViewModel
import de.leadfrog.app_new.presentation.base.SingleLiveEvent
import de.leadfrog.app_new.presentation.viewmodel.DiagramModel
import javax.inject.Inject

object HomeContainerViewModel {
    var diagram : DiagramModel = DiagramModel()
}