package ua.regin.badproduct.ui.addictive.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import org.parceler.Parcels
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
        setSupportActionBar(toolbar);
        additive = Parcels.unwrap(intent.getParcelableExtra(ADDITIVE_EXTRA));
        title = additive?.name;
    }

    public companion object {
        const val ADDITIVE_EXTRA = "additiveExtra";
        public fun newInstance(context: Context, additive: Additive): Intent = Intent(context, AdditiveDetailsActivity::class.java).apply {
            putExtra(ADDITIVE_EXTRA, Parcels.wrap(additive));
        }
    }
}
