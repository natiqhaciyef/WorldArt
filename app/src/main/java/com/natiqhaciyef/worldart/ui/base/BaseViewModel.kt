package com.natiqhaciyef.worldart.ui.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    companion object {
        const val WRONG_FILLED_ALL_INPUTS_REASON =
            "Email is not correct filled or Password have to be over 8 character."
        const val WRONG_FILLED_EMAIL_INPUT_REASON = "Email is not correct filled"

        const val DATA_LOADED_SUCCESSFULLY = "Data loaded successfully"
    }
}