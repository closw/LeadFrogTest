package de.leadfrog.app_new.presentation.viewmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactModel(var name : String? = null,
                        var phone: String? = null,
                        var email: String? = null,
                        var company: String? = null,
                        var position: String? = null) : Parcelable