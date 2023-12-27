package com.natiqhaciyef.worldart.domain.usecase

import com.natiqhaciyef.worldart.domain.repository.BaseRepository

open class BaseUseCase<T: BaseRepository>(
    protected val repository: T
)
