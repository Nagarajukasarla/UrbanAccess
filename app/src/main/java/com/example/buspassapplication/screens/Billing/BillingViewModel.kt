package com.example.buspassapplication.screens.Billing

import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.BillingService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BillingViewModel @Inject constructor(
    private val billingService : BillingService
) : AppViewModel() {
    init {

    }

}
