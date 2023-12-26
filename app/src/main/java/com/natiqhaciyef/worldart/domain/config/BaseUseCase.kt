package com.natiqhaciyef.worldart.domain.config

open class BaseUseCase<T: BaseRepository>(
    protected val repository: T
)
