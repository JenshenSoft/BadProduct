package ua.regin.badproduct.ui.main;

import android.os.Build
import android.support.annotation.ColorRes
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.OptionsMenu
import org.androidannotations.annotations.ViewById
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.main.adapter.PagerAdapter
import ua.regin.badproduct.util.AnimationUtils
import ua.regin.badproduct.util.getBackgroundColor
import ua.regin.badproduct.util.tab.selected

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
open class MainActivity : BaseActivity() {

    @field:ViewById
    lateinit var viewPager: ViewPager;

    @field:ViewById
    lateinit var tabLayout: TabLayout;

    @field:ViewById
    lateinit var toolbar: Toolbar;

    @AfterViews
    open fun afterViews() {
        setSupportActionBar(toolbar);
        val pagerAdapter = PagerAdapter(supportFragmentManager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_view_list_white_48px).selected(getContext(), true));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_check_circle_white_48px).selected(getContext(), false));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_error_outline_white_48px).selected(getContext(), false));

        viewPager.adapter = pagerAdapter;
        viewPager.offscreenPageLimit = 3;
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
