package ua.regin.badproduct.ui;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {

    fun getContext() = this;

}
