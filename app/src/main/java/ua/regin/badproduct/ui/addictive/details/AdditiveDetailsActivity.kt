package ua.regin.badproduct.ui.addictive.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer
import ua.regin.badproduct.R
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.addictive.details.adapter.AdditivePagerAdapter
import ua.regin.badproduct.ui.view.BetterViewPager
import ua.regin.badproduct.util.AnimationUtils
import ua.regin.badproduct.util.getBackgroundColor
import ua.regin.badproduct.util.knife.bindView
import java.util.*

class AdditiveDetailsActivity : BaseActivity() {

    override fun getResId() = R.layout.activity_additive_details;

    private val viewPager: BetterViewPager by bindView(R.id.viewPager);
    private val toolbar: Toolbar by bindView(R.id.toolbar);

    lateinit private var additiveList: List<Additive>;
    private var position = 0;

    override fun onReceiveIntent() {
        additiveList = intent.getSerializableExtra(EXTRA_ADDITIVE_LIST) as ArrayList<Additive>;
        position = intent.getIntExtra(EXTRA_POSITION, position);
    }

    override fun afterViews() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener { finish(); }
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24px);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        viewPager.adapter = AdditivePagerAdapter(supportFragmentManager, additiveList);
        viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView));
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                setAdditive(additiveList[position]);
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

        })
        viewPager.currentItem = position;
    }

    private fun setAdditive(additive: Additive) {
        supportActionBar.title = additive.name;
        supportActionBar.subtitle = additive.similar;
        setHeaderColor(additive);
    }

    private fun setHeaderColor(additive: Additive) {
        if (Build.VERSION.SDK_INT >= 21) {
            AnimationUtils.animateColorChange(window, "statusBarColor", window.statusBarColor, ContextCompat.getColor(this, if (additive.danger < 2) R.color.colorPrimaryDarkGreen else R.color.colorPrimaryDarkRed));
        }
        AnimationUtils.animateColorChange(toolbar, "backgroundColor", toolbar.getBackgroundColor(), ContextCompat.getColor(this, if (additive.danger < 2) R.color.colorPrimaryGreen else R.color.colorPrimaryRed));
    }

    public companion object {
        const val EXTRA_ADDITIVE_LIST = "extraAdditiveList";
        const val EXTRA_POSITION = "extraPosition";
        public fun newInstance(context: Context, additiveList: ArrayList<Additive>, position: Int): Intent = Intent(context, AdditiveDetailsActivity::class.java).apply {
            putExtra(EXTRA_ADDITIVE_LIST, additiveList);
            putExtra(EXTRA_POSITION, position);
        }
    }
}
