package ua.regin.badproduct.ui.addictive.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.util.knife.bindView

class AdditiveDetailsActivity : BaseActivity() {
    override fun getResId() = R.layout.activity_additive_details;

    private val toolbar: Toolbar by bindView(R.id.toolbar);

    var additive: Additive? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        additive = intent.getSerializableExtra(ADDITIVE_EXTRA)as Additive;
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, AdditiveDetailsFragment.newInstance(additive!!)).commit();
        }
        setSupportActionBar(toolbar);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24px);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener { finish(); }
        title = additive?.name;
    }

    public companion object {
        const val ADDITIVE_EXTRA = "additiveExtra";
        public fun newInstance(context: Context, additive: Additive): Intent = Intent(context, AdditiveDetailsActivity::class.java).apply {
            putExtra(ADDITIVE_EXTRA, additive);
        }
    }
}
