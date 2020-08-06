package de.leadfrog.app_new.mokeutils

import de.leadfrog.app_new.presentation.viewmodel.ContactModel
import de.leadfrog.app_new.presentation.viewmodel.LeadModel
import de.leadfrog.app_new.presentation.base.type.Status


fun generateLeadsList(): MutableList<LeadModel> {
    val leads = mutableListOf<LeadModel>()
    val item1 = ContactModel().apply {
        name = "Pushkin Alexandr Sergeevich"
        company = "Russian literature"
        position = "Poet"
        email = "pushkin@ruslit.com"
        phone = "80017991837"
    }
    leads.add(generateLead(item1))
    val item2 = ContactModel().apply {
        name = "Lermontov Mihail Urievich"
        company = "Russian literature"
        position = "Poet"
        email = "lermontov@ruslit.com"
        phone = "80018141841"
    }
    leads.add(generateLead(item2))
    val item3 = ContactModel().apply {
        name = "Nikolay Vladimirovich Gogol"
        company = "Russian literature"
        position = "Writer"
        email = "gogol@ruslit.com"
        phone = "80018091852"
    }
    leads.add(generateLead(item3))
    val item4 = ContactModel().apply {
        name = "Lev Nikolaevich Tolstoy"
        company = "Russian literature"
        position = "Writer"
        email = "tolstoy@ruslit.com"
        phone = "80018281910"
    }
    leads.add(generateLead(item4))
    val item5 = ContactModel().apply {
        name = "Alexandr Nikolaevich Ostrovskiy"
        company = "Russian literature"
        position = "Writer"
        email = "ostrovskiy@ruslit.com"
        phone = "80018231886"
    }
    leads.add(generateLead(item5))

    return leads
}

fun generateLead(contactModel: ContactModel): LeadModel {
    return LeadModel().apply {
        this.contact = contactModel
        this.status = Status.SYNCHRONIZED
    }
}

fun generateContacts(): MutableList<ContactModel> {
    val contacts = mutableListOf<ContactModel>()
    contacts.add(ContactModel().apply {
        name = "Pushkin Alexandr Sergeevich"
        company = "Russian literature"
        position = "Poet"
        email = "pushkin@ruslit.com"
        phone = "80017991837"
    })

    contacts.add(ContactModel().apply {
        name = "Lermontov Mihail Urievich"
        company = "Russian literature"
        position = "Poet"
        email = "lermontov@ruslit.com"
        phone = "80018141841"
    })

    contacts.add(ContactModel().apply {
        name = "Nikolay Vladimirovich Gogol"
        company = "Russian literature"
        position = "Writer"
        email = "gogol@ruslit.com"
        phone = "80018091852"
    })

    contacts.add(ContactModel().apply {
        name = "Lev Nikolaevich Tolstoy"
        company = "Russian literature"
        position = "Writer"
        email = "tolstoy@ruslit.com"
        phone = "80018281910"
    })
    contacts.add(ContactModel().apply {
        name = "Alexandr Nikolaevich Ostrovskiy"
        company = "Russian literature"
        position = "Writer"
        email = "ostrovskiy@ruslit.com"
        phone = "80018231886"
    })
    return contacts
}
