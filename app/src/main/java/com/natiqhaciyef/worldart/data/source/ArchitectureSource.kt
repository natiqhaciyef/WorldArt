package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel
import com.natiqhaciyef.worldart.data.network.service.ArchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArchitectureSource(
    private val service: ArchService,
) {

    suspend fun getAllArchitecturesRemote() = withContext(Dispatchers.IO) {
        service.getAllArchitectures()
    }

    suspend fun insertArchitecturesRemote(archNetworkModel: ArchitectureNetworkModel) =
        withContext(Dispatchers.IO) {
            service.insertArchitecture(
                arch = archNetworkModel.arch,
                publishDate = archNetworkModel.publishDate
            )
        }

    suspend fun updateArchitecturesRemote(archNetworkModel: ArchitectureNetworkModel) =
        withContext(Dispatchers.IO) {
            service.updateArchitecture(
                id = archNetworkModel.id,
                arch = archNetworkModel.arch,
                publishDate = archNetworkModel.publishDate
            )
        }

    suspend fun deleteArchitecturesRemote(id: Int) =
        withContext(Dispatchers.IO) {
            service.deleteArchitecture(id = id)
        }
}