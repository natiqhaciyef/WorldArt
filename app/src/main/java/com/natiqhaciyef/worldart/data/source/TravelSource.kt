package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.TravelService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TravelSource(
    private val service: TravelService
) {

    suspend fun getAllTravels() = withContext(Dispatchers.IO) {
        service.getAllTravels()
    }
}
