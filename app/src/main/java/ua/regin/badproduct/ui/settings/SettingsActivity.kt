package ua.regin.badproduct.ui.settings

import android.os.Bundle
import android.support.v7.widget.Toolbar
import net.xpece.android.support.preference.Fixes
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.util.knife.bindView

class SettingsActivity : BaseActivity() {
    override fun getResId() = R.layout.activity_settings;

    private val toolbar: Toolbar by bindView(R.id.toolbar);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fixes.updateLayoutInflaterFactory(layoutInflater)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, SettingsFragment.newInstance(), null).commit()
        }
    }

    override fun afterViews() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}