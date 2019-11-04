package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.R
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter.LoginPresenter
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view.LoginView

class LoginActivity : AppCompatActivity(),
    LoginView {
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenter=
            LoginPresenter(
                this
            )
        loginPresenter.validateUser("hello", "")
    }
    override fun navigateToHome() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPass() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
