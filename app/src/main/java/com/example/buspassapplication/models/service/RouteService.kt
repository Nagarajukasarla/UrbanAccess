package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.Route
import com.example.buspassapplication.models.utils.OperationStatus

interface RouteService {
    val currentUserId: String

    suspend fun setRoute(route: Route): OperationStatus

    suspend fun getRoute(): Route?

}