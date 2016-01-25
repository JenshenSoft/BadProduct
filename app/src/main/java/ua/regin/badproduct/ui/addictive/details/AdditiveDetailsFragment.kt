package ua.regin.badproduct.ui.addictive.details

import android.widget.TextView
import com.github.vmironov.jetpack.arguments.bindArgument
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.ui.BaseFragment
import ua.regin.badproduct.util.knife.bindView

class AdditiveDetailsFragment : BaseFragment() {
    override fun getResId() = R.layout.fragment_details_additive;
    override fun getOptionsId() = R.menu.menu_search;

    private val dangerousView: TextView by bindView(R.id.dangerousView);
    private val naturalityView: TextView by bindView(R.id.naturalityView);

    var additive by bindArgument<Additive>()

    fun afterViews() {
        dangerousView.text = context.getString(R.string.details_danger, additive.danger);
        naturalityView.text = additive.naturality.toString();
    }

    public companion object {
        public fun newInstance(additive: Additive): AdditiveDetailsFragment = AdditiveDetailsFragment().apply {
            this.additive = additive;
        }
    }
}
