package ua.regin.badproduct.ui.main;

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.addictive.AddictiveFragment
import ua.regin.badproduct.util.extend.show
import ua.regin.badproduct.util.knife.bindView

class MainActivity : BaseActivity() {

    private val navigationView: NavigationView by bindView(R.id.navigationView);
    private val drawerLayout: DrawerLayout by bindView(R.id.drawerLayout);

    override fun getResId() = R.layout.activity_main;

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            AddictiveFragment().show(supportFragmentManager);
        }
    }

    override fun afterViews() {
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            menuItem.setChecked(true)
            val fragment: Fragment
            when (menuItem.itemId) {
                R.id.drawer_additive -> fragment = AddictiveFragment();
                else -> throw IllegalArgumentException("Unknown drawer id");
            }

            fragment.show(supportFragmentManager);
            drawerLayout.closeDrawers()
            true
        })
    }
}
