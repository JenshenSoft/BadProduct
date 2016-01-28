package ua.regin.badproduct.ui.addictive.details

import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.github.vmironov.jetpack.arguments.bindArgument
import com.squareup.picasso.Picasso
import ua.regin.badproduct.R
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.util.knife.bindView

class AdditiveDetailsFragment : BaseFragment() {
    override fun getResId() = R.layout.fragment_details_additive;
    override fun getOptionsId() = R.menu.menu_search;

    private val dangerousView: TextView by bindView(R.id.dangerousView);
    private val naturalityView: TextView by bindView(R.id.naturalityView);
    private val imageView: ImageView by bindView(R.id.imageView);
    private val webView: WebView by bindView(R.id.webView);

    private var additive by bindArgument<Additive>();

    override fun afterViews() {
        dangerousView.text = context.getString(R.string.details_danger, additive.danger);
        naturalityView.text = additive.naturality.toString();
        Picasso.with(context).load(additive.image).fit().centerCrop().into(imageView);
        webView.loadDataWithBaseURL(null, additive.description, "text/html", "UTF-8", null);
    }

    public companion object {
        public fun newInstance(additive: Additive): AdditiveDetailsFragment = AdditiveDetailsFragment().apply {
            this.additive = additive;
        }
    }
}
