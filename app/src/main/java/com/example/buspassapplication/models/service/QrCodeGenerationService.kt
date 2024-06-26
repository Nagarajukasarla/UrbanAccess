package com.example.buspassapplication.models.service

import android.graphics.Bitmap

interface QrCodeGenerationService {
    fun generateQrCode(data: String): Bitmap
}