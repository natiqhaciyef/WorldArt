package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.ScienceService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScienceSource(
    private val service: ScienceService
) {

    suspend fun getAllSciences() = withContext(Dispatchers.IO) {
        service.getAllSciences()
    }
}