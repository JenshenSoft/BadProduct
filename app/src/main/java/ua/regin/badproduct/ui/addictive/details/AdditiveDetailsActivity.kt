package ua.regin.badproduct.ui.addictive.details

import android.content.Context
import android.content.Intent
import android.support.v4.view.ViewPager
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer
import ua.regin.badproduct.R
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.BaseActivity
import ua.regin.badproduct.ui.addictive.details.adapter.AdditivePagerAdapter
import ua.regin.badproduct.util.knife.bindView
import java.util.*

class AdditiveDetailsActivity : BaseActivity() {

    override fun getResId() = R.layout.activity_additive_details;

    private val viewPager: ViewPager by bindView(R.id.viewPager)

    lateinit private var additiveList: List<Additive>;
    private var position = 0;

    override fun onReceiveIntent() {
        additiveList = intent.getSerializableExtra(EXTRA_ADDITIVE_LIST) as ArrayList<Additive>;
        position = intent.getIntExtra(EXTRA_POSITION, position);
    }

    override fun afterViews() {
        super.afterViews();
        viewPager.adapter = AdditivePagerAdapter(supportFragmentManager, additiveList);
        viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView));
        viewPager.currentItem = position;
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
