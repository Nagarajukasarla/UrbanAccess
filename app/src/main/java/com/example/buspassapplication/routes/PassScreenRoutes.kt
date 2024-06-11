package com.example.buspassapplication.routes

sealed class PassScreenRoutes(val route: String) {
    object GeneralForm: PassScreenRoutes(route = "general_form_screen")
    object StudentForm: PassScreenRoutes(route = "student_form_screen")
    object RouteForm: PassScreenRoutes(route = "route_form_screen")
    object MetroForm: PassScreenRoutes(route = "metro_form_screen")
    object TicketStatus: PassScreenRoutes(route = "ticket_status_screen")
}