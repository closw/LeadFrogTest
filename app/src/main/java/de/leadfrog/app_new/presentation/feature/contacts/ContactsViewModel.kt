package de.leadfrog.app_new.presentation.feature.contacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.leadfrog.app_new.mokeutils.generateContacts
import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.base.SingleLiveEvent
import javax.inject.Inject

class ContactsViewModel @Inject constructor(): ViewModel() {

    val contactsLiveData = MutableLiveData<MutableList<ContactModel>>()

    fun initList() =
        contactsLiveData.postValue(generateContacts())
}