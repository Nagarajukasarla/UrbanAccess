package com.example.buspassapplication.models.utils

import android.util.Log
import com.example.buspassapplication.enums.GenderEnum
import org.checkerframework.checker.units.qual.Area
import java.util.Calendar
import kotlin.math.log

object ValidationUtils {

    private fun basicTextValidation(value: String?, type: String): ValidationResult {
        return if (value.isNullOrBlank()) {
            ValidationResult.Error("$type cannot be blank")
        } else ValidationResult.Success
    }

    private fun nameValidation(value: String?, type: String): ValidationResult {
        return when {
            value.isNullOrBlank() -> ValidationResult.Error("$type cannot be empty")
            value.length < 2 -> ValidationResult.Error("$type must be at least 2 characters")
            value.length > 50 -> ValidationResult.Error("$type is too long")
            !value.matches(Regex("^[A-Za-z ]+$")) -> ValidationResult.Error("$type can only contain letters")
            else -> ValidationResult.Success
        }
    }

    fun validateSurname(surname: String?): ValidationResult {
        return nameValidation(surname, "Surname")
    }

    fun validateLastname(lastname: String?): ValidationResult {
        return nameValidation(lastname, "Lastname")
    }

    fun validateGuardianName(guardianName: String?): ValidationResult {
        return nameValidation(guardianName, "Guardian")
    }

//    fun validateDateOfBirth(dob: String?): ValidationResult {
//        if (dob.isNullOrBlank()) return ValidationResult.Error("Date of Birth is required")
//
//        try {
//            val parts = dob.split("-")
//            if (parts.size != 3) return ValidationResult.Error("Invalid date format. Use YYYY-MM-DD")
//
//            val year = parts[0].toInt()
//            val month = parts[1].toInt()
//            val day = parts[2].toInt()
//
//            val birthDate = Calendar.getInstance().apply {
//                set(year, month - 1, day)
//            }
//            Log.d("ValidationUtils", "Input DOB: $dob")
//            Log.d("ValidationUtils", "Birth Date: $birthDate")
//
//            val currentDate = Calendar.getInstance()
//            Log.d("ValidationUtils", "Current Date: $currentDate")
//            Log.d("ValidationUtils", "Current Year: ${currentDate.get(Calendar.YEAR)}")
//            Log.d("ValidationUtils", "Birth Year: ${birthDate.get(Calendar.YEAR)}")
//            val age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
//            Log.d("ValidationUtils", "Age: ${age.toString()}")
//
//            return when {
//                birthDate.after(currentDate) -> ValidationResult.Error("Date of Birth cannot be in the future")
//                age < 5 -> ValidationResult.Error("Applicant must be at least 5 years old")
//                age > 80 -> ValidationResult.Error("Applicant must be under 80 years old")
//                else -> ValidationResult.Success
//            }
//        } catch (e: Exception) {
//            return ValidationResult.Error("Invalid date format")
//        }
//    }

    fun validateDateOfBirth(dob: String?): ValidationResult {
        if (dob.isNullOrBlank()) return ValidationResult.Error("Date of Birth is required")
        try {
            val parts = dob.split("-")
            if (parts.size != 3) return ValidationResult.Error("Invalid date format. Use DD-MM-YYYY")

            // Assuming the format is dd-MM-yyyy
            val day = parts[0].toInt()
            val month = parts[1].toInt()
            val year = parts[2].toInt()

            val birthDate = Calendar.getInstance().apply {
                set(year, month - 1, day)
            }
            Log.d("ValidationUtils", "Input DOB: $dob")
            Log.d("ValidationUtils", "Birth Date: $birthDate")

            val currentDate = Calendar.getInstance()
            Log.d("ValidationUtils", "Current Date: $currentDate")
            Log.d("ValidationUtils", "Current Year: ${currentDate.get(Calendar.YEAR)}")
            Log.d("ValidationUtils", "Birth Year: ${birthDate.get(Calendar.YEAR)}")

            // Calculate age accurately
            var age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
            if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
                age--
            }
            Log.d("ValidationUtils", "Age: $age")

            return when {
                birthDate.after(currentDate) -> ValidationResult.Error("Date of Birth cannot be in the future")
                age < 5 -> ValidationResult.Error("Applicant must be at least 5 years old")
                age > 80 -> ValidationResult.Error("Applicant must be under 80 years old")
                else -> ValidationResult.Success
            }
        } catch (e: Exception) {
            return ValidationResult.Error("Invalid date format")
        }
    }


    fun validatePhone(phone: String?): ValidationResult {
        if (phone.isNullOrBlank()) return ValidationResult.Error("Phone number is required")

        val phoneRegex = Regex("^(\\+?91|0)?[6-9]\\d{9}$")
        return if (phoneRegex.matches(phone.replace(Regex("[^0-9]"), ""))) {
            ValidationResult.Success
        } else {
            ValidationResult.Error("Invalid phone number")
        }
    }

    fun validateEmail(email: String?): ValidationResult {
        if (email.isNullOrBlank()) return ValidationResult.Error("Email is required")

        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")
        return if (emailRegex.matches(email)) {
            ValidationResult.Success
        } else {
            ValidationResult.Error("Invalid email format")
        }
    }

    fun validateAadhar(aadhar: String?): ValidationResult {
        if (aadhar.isNullOrBlank()) return ValidationResult.Error("Aadhar number is required")

        val aadharRegex = Regex("^[2-9]{1}[0-9]{3}\\s?[0-9]{4}\\s?[0-9]{4}$")
        return if (aadharRegex.matches(aadhar.replace(Regex("\\s"), ""))) {
            ValidationResult.Success
        } else {
            ValidationResult.Error("Invalid Aadhar number")
        }
    }

    fun validateDuration(duration: String?): ValidationResult {
        val validDurations = listOf("Weekly", "Monthly", "Quarterly", "Half yearly")
        return when {
            duration.isNullOrBlank() -> ValidationResult.Error("Duration is required")
            duration !in validDurations -> ValidationResult.Error("Invalid duration selected")
            else -> ValidationResult.Success
        }
    }

    fun validateDivision(division: String?): ValidationResult {
        return when {
            division.isNullOrBlank() -> ValidationResult.Error("Division is required")
            else -> ValidationResult.Success
        }
    }

    fun validateGender(gender: String?): ValidationResult {
        return when {
            gender.isNullOrBlank() -> ValidationResult.Error("Gender is required")
            GenderEnum.entries.none { it.value == gender } -> ValidationResult.Error("Invalid gender selected")
            else -> ValidationResult.Success
        }
    }

    fun validateHouseNumber(houseNumber: String?): ValidationResult {
        return basicTextValidation(houseNumber, "House Number")
    }
    fun validateStreet(street: String?): ValidationResult {
        return basicTextValidation(street, "Street")
    }

    fun validateArea(area: String?): ValidationResult {
        return basicTextValidation(area, "Area")
    }

    fun validateDistrict(district: String?): ValidationResult {
        return basicTextValidation(district, "District")
    }

    fun validateCity(city: String?): ValidationResult {
        return basicTextValidation(city, "City")
    }
    fun validateState(state: String?): ValidationResult {
        return basicTextValidation(state, "State")
    }

    fun validatePincode(pincode: String?): ValidationResult {
        return basicTextValidation(pincode, "Pincode")
    }



}

sealed class ValidationResult {
    data object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}