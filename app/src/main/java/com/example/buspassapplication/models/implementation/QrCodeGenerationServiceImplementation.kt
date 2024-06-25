package com.example.buspassapplication.models.implementation

import android.graphics.Bitmap
import com.example.buspassapplication.models.service.QrCodeGenerationService
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import javax.inject.Inject

class QrCodeGenerationServiceImplementation @Inject constructor() : QrCodeGenerationService {
    override fun generateQrCode(data: String): Bitmap {
        val multiFormatWriter = MultiFormatWriter()
        return try {
            BarcodeEncoder()
                .createBitmap(
                    multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200)
                )
        } catch (writerException: WriterException) {
            writerException.printStackTrace()
            Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888).apply {
                eraseColor(android.graphics.Color.RED)
            }
        }
    }

}