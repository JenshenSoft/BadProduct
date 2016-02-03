package ua.regin.badproduct.ui.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.util.knife.bindView

class SearchActivity : BaseActivity() {
    override fun getResId() = R.layout.activity_search;

    private val toolbar: Toolbar by bindView(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment.newInstance(intent.getStringExtra(SearchManager.QUERY))).commit();
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent);
        supportFragmentManager
    }

    override fun afterViews() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener { finish() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
