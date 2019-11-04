package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter

import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view.LoginView

class LoginPresenter(var loginView: LoginView)  {


    fun peformLogin(userName: String, userPassword: String) {
        if (userName == "hello"){
            loginView.navigateToHome()
        }
    }

    fun validateUser(userName: String, userPassword: String) {
        if (userPassword == ""){
            loginView.onPasswordError()
        }
    }
}