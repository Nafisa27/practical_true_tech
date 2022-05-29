package com.app.practical.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.practical.BR
import com.app.practical.R
import com.app.practical.base.BaseActivity
import com.app.practical.databinding.ActivitySplashBinding
import com.app.practical.ktx.startNewActivity
import com.app.practical.ui.store_list.StoreListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val layoutId = R.layout.activity_splash

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moveToNext()
    }

    private fun moveToNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            startNewActivity(StoreListActivity::class.java, true)
        }, 3000)
    }

    override fun setUpObserver() {
    }

    override fun init() {
    }
}