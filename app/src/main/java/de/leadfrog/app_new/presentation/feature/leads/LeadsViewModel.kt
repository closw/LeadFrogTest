package de.leadfrog.app_new.presentation.feature.leads

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.leadfrog.app_new.mokeutils.generateLeadsList
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.base.SingleLiveEvent
import de.leadfrog.app_new.presentation.viewmodel.LeadModel
import javax.inject.Inject

class LeadsViewModel@Inject constructor(): ViewModel()  {

    val leadsLiveData = MutableLiveData<MutableList<LeadModel>>()

    fun initList() =
        leadsLiveData.postValue(generateLeadsList())
}