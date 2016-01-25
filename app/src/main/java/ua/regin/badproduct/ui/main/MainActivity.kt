package ua.regin.badproduct.ui.main;

import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Menu
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.main.adapter.PagerAdapter
import ua.regin.badproduct.util.AnimationUtils
import ua.regin.badproduct.util.getBackgroundColor
import ua.regin.badproduct.util.knife.bindView
import ua.regin.badproduct.util.tab.selected

class MainActivity : BaseActivity() {
    override fun getResId() = R.layout.activity_main;

    private val tabLayout: TabLayout by bindView(R.id.tabLayout);
    private val viewPager: ViewPager by bindView(R.id.viewPager);
    private val toolbar: Toolbar by bindView(R.id.toolbar);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun afterViews() {
        val pagerAdapter = PagerAdapter(supportFragmentManager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_view_list_white_48px).selected(getContext(), true));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_check_circle_white_48px).selected(getContext(), false));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_error_outline_white_48px).selected(getContext(), false));

        viewPager.adapter = pagerAdapter;
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position;
                when (tab.position) {
                    0 -> {
                        setHeaderColor(R.color.colorPrimaryDark, R.color.colorPrimary);
                        setTitle(R.string.main_title_all);
                    }
                    1 -> {
                        setHeaderColor(R.color.colorPrimaryDarkGreen, R.color.colorPrimaryGreen);
                        setTitle(R.string.main_title_notdanger);
                    }
                    2 -> {
                        setHeaderColor(R.color.colorPrimaryDarkRed, R.color.colorPrimaryRed);
                        setTitle(R.string.main_title_danger);
                    };
                }
                tab.selected(getContext(), true);
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.selected(getContext(), false)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    private fun setHeaderColor(@ColorRes statusBarColorRes: Int, @ColorRes toolbarBarColorRes: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            AnimationUtils.animateColorChange(window, "statusBarColor", window.statusBarColor, ContextCompat.getColor(getContext(), statusBarColorRes));
        }
        AnimationUtils.animateColorChange(toolbar, "backgroundColor", toolbar.getBackgroundColor(), ContextCompat.getColor(getContext(), toolbarBarColorRes));
        AnimationUtils.animateColorChange(tabLayout, "backgroundColor", toolbar.getBackgroundColor(), ContextCompat.getColor(getContext(), toolbarBarColorRes));
    }
}
