package ua.regin.badproduct.ui.addictive.details

import android.os.Build
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.github.vmironov.jetpack.arguments.bindArgument
import com.squareup.picasso.Picasso
import ua.regin.badproduct.R
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.util.fragment.setToolbar
import ua.regin.badproduct.util.knife.bindView

class AdditiveDetailsFragment : BaseFragment() {
    override fun getResId() = R.layout.fragment_details_additive;
    override fun getOptionsId() = R.menu.menu_search;

    private val dangerousView: TextView by bindView(R.id.dangerousView);
    private val naturalityView: TextView by bindView(R.id.naturalityView);
    private val toolbar: Toolbar by bindView(R.id.toolbar);
    private val collapsingToolbarLayout: CollapsingToolbarLayout by bindView(R.id.collapsingToolbarLayout);
    private val imageView: ImageView by bindView(R.id.imageView);

    var additive by bindArgument<Additive>();

    override fun afterViews() {
        dangerousView.text = context.getString(R.string.details_danger, additive.danger);
        naturalityView.text = additive.naturality.toString();
        setToolbar(toolbar);
        toolbar.setNavigationOnClickListener { activity.finish(); }
        toolbar.title = additive.name;
        Picasso.with(context).load(additive.image).fit().centerCrop().into(imageView);
        changeHeaderColor();
    }

    private fun changeHeaderColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.window.statusBarColor = ContextCompat.getColor(context, if (additive.danger < 2) R.color.colorPrimaryDarkGreen else R.color.colorPrimaryDarkRed);
        }
        collapsingToolbarLayout.setContentScrimResource(if (additive.danger < 2) R.color.colorPrimaryGreen else R.color.colorPrimaryRed)
    }

    public companion object {
        public fun newInstance(additive: Additive): AdditiveDetailsFragment = AdditiveDetailsFragment().apply {
            this.additive = additive;
        }
    }
}
