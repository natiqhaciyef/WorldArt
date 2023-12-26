package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.HistoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistorySource(
    private val service: HistoryService
) {

    suspend fun getAllHistories() = withContext(Dispatchers.IO) {
        service.getAllHistories()
    }
}