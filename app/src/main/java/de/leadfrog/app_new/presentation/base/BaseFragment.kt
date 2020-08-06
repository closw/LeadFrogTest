package de.leadfrog.app_new.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

abstract class BaseFragment: Fragment() {

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initDisplayableData(view)
    }

    abstract fun inject()

    abstract fun initViews()

    abstract fun initDisplayableData(view: View)

    fun fragmentNavigate(destination: Int) =
        Navigation.findNavController(requireView()).navigate(destination, null)

    fun directionNavigate(destination: NavDirections) =
        Navigation.findNavController(requireView()).navigate(destination)
}