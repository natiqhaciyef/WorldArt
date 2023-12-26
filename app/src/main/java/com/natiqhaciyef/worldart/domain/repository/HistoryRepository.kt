package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.domain.result.UIResult

interface HistoryRepository {
    suspend fun getAllHistories(): List<UIResult<HistoryModel>>?
}