package ua.regin.badproduct.ui;

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());
        onReceiveIntent();
        injectComponent();
        afterViews();
    }

    fun getContext() = this;

    abstract fun getResId(): Int;

    open protected fun onReceiveIntent() {
    }

    open protected fun injectComponent() {
    }

    open protected fun afterViews() {
    }
}
