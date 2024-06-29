package com.example.buspassapplication.screens.pass

import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PassViewModel @Inject constructor(

) : AppViewModel() {
    val passes = MutableStateFlow<List<*>>()




}
