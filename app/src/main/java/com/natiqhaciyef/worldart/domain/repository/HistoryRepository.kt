package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.domain.config.BaseRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

interface HistoryRepository: BaseRepository {

    suspend fun getAllHistories(): List<UIResult<HistoryModel>>?
}