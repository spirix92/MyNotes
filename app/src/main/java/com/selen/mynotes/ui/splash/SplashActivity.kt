package com.selen.mynotes.ui.splash

import android.os.Handler
import org.koin.android.viewmodel.ext.android.viewModel
import com.selen.mynotes.ui.base.BaseActivity
import ru.geekbrains.gb_kotlin.ui.main.MainActivity

class SplashActivity : BaseActivity<Boolean?, SplashViewState>(){

    override val viewModel: SplashViewModel by viewModel()

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({viewModel.requestUser()}, 1000)
    }

    override fun renderData(data: Boolean?) {
         data?.takeIf { it }?.let {
             startMainActivity()
         }
    }

    fun startMainActivity(){
        MainActivity.start(this)
        finish()
    }

}