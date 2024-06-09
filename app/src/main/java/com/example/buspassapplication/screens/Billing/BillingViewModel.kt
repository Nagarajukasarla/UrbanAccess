package com.example.buspassapplication.screens.Billing

import android.app.Activity
import android.app.Application
import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BillingViewModel @Inject constructor(
    private val application: Application,
) : AppViewModel() {
    fun onSubmitClick(activity: Activity) {
        TODO("Not yet implemented")
    }

}
