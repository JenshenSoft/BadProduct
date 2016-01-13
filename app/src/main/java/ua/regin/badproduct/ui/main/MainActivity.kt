package ua.regin.badproduct.ui.main;

import android.os.Bundle
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.addictive.AddictiveFragment
import ua.regin.badproduct.util.extend.show

class MainActivity : BaseActivity() {

    override fun getResId() = R.layout.activity_main;

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            AddictiveFragment().show(supportFragmentManager);
        }
    }

    override fun afterViews() {

    }

}
