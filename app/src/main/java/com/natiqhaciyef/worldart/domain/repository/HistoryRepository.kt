package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface HistoryRepository: BaseRepository {

    suspend fun getAllHistories(): List<UIResult<HistoryModel>>?
}