package com.natiqhaciyef.worldart.domain.base

open class BaseUseCase<T: BaseRepository>(
    protected val repository: T
)
