package de.leadfrog.app_new.presentation.base

import de.leadfrog.app_new.presentation.viewmodel.LeadModel

interface ItemClickListener<in T>{
    fun click(item: T)
}