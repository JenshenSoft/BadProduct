package ua.regin.badproduct.ui;

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());
        afterViews();
    }

    abstract fun getResId(): Int;
    abstract fun afterViews();
}
