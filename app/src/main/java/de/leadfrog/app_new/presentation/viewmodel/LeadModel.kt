package de.leadfrog.app_new.presentation.viewmodel

import de.leadfrog.app_new.presentation.base.type.Status

data class LeadModel(var contact: ContactModel? = null,
                     var status: Status? = null)