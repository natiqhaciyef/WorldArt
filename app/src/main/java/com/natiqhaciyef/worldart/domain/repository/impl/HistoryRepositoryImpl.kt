package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.data.source.HistorySource
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.repository.HistoryRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

class HistoryRepositoryImpl(
    private val ds: HistorySource
) : HistoryRepository {
    override suspend fun getAllHistories(): List<UIResult<HistoryModel>>? {
        return ds.getAllHistories().archResult?.map { it.toUIModel() }
    }
}