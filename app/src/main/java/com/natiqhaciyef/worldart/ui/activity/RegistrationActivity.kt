package com.natiqhaciyef.worldart.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class RegistrationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}