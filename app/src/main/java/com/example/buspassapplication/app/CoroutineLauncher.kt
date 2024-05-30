package com.example.buspassapplication.app

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun CoroutineScope.launchCatching(
    block: suspend () -> Unit,
    onError: (Throwable) -> Unit
) {
    launch {
        try {
            block()
        } catch (e: Throwable) {
            onError(e)
        }
    }
}