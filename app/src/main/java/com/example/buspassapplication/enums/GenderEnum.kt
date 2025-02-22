package com.example.buspassapplication.enums

enum class GenderEnum(val value: String) {
    MALE("Male"),
    FEMALE("Female"),
    TRANSGENDER("Transgender"),
    OTHER("Other");

    override fun toString(): String {
        return value
    }
}
