package ua.regin.badproduct.ui.addictive.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.squareup.picasso.Picasso
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.util.knife.bindView

class AdditiveDetailsActivity : BaseActivity() {
    override fun getResId() = R.layout.activity_additive_details;

    private val toolbar: Toolbar by bindView(R.id.toolbar);
    private val collapsingToolbarLayout: CollapsingToolbarLayout by bindView(R.id.collapsingToolbarLayout);
    private val imageView: ImageView by bindView(R.id.imageView);

    lateinit var additive: Additive;

    override fun onReceiveIntent() {
        additive = intent.getSerializableExtra(ADDITIVE_EXTRA) as Additive;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, AdditiveDetailsFragment.newInstance(additive)).commit();
        }
        setSupportActionBar(toolbar);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24px);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener { finish(); }
        title = additive.name;
        Picasso.with(getContext()).load(additive.image).fit().centerCrop().into(imageView);

        changeHeaderColor();
    }

    public companion object {
        const val ADDITIVE_EXTRA = "additiveExtra";
        public fun newInstance(context: Context, additive: Additive): Intent = Intent(context, AdditiveDetailsActivity::class.java).apply {
            putExtra(ADDITIVE_EXTRA, additive);
        }
    }

    private fun changeHeaderColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            window.statusBarColor = ContextCompat.getColor(getContext(), if (additive.danger < 2) R.color.colorPrimaryDarkGreen else R.color.colorPrimaryDarkRed);
        }
        collapsingToolbarLayout.setContentScrimResource(if (additive.danger < 2) R.color.colorPrimaryGreen else R.color.colorPrimaryRed)
    }
}
