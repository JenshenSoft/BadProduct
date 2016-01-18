package ua.regin.badproduct.ui.addictive.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
import ua.regin.badproduct.ui.addictive.view.DangerView
import ua.regin.badproduct.util.knife.bindView

class AdditiveAdapter(val context: Context, val onClick: (additive: Additive) -> Unit) : RecyclerView.Adapter<AdditiveAdapter.ViewHolder>() {

    var additiveList: List<Additive>? = null;
        set(value) {
            field = value;
            notifyDataSetChanged();
            filteredList = additiveList;
        }

    private var filteredList: List<Additive>? = null;

    fun search(query: String) {
        filteredList = additiveList!!.filter { it.synonym.equals(query) };
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdditiveAdapter.ViewHolder? {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_additive, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return filteredList?.size ?: 0;
    }

    override fun onBindViewHolder(holder: AdditiveAdapter.ViewHolder?, position: Int) {
        holder?.bindAdditive(filteredList!![position], onClick);
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameView: TextView by bindView(R.id.nameView);
        val synonymView: TextView by bindView(R.id.synonymView);
        val dangerView: DangerView by bindView(R.id.dangerView);

        fun bindAdditive(additive: Additive, function: (additive: Additive) -> Unit) {
            itemView.setOnClickListener { function(additive) }
            with(additive) {
                nameView.text = context.getString(R.string.additive_item_title, name, similar);
                if (!synonym.isNullOrBlank()) {
                    synonymView.text = synonym;
                    synonymView.visibility = View.VISIBLE;
                } else {
                    synonymView.visibility = View.GONE;
                }

                dangerView.setDangerCount(danger!!);
                when (naturality) {
                    Additive.Naturality.Natural -> nameView.setTextColor(context.resources.getColor(R.color.colorPrimaryDarkGreen));
                    Additive.Naturality.Synthetic -> nameView.setTextColor(context.resources.getColor(R.color.colorPrimaryDarkRed));
                    Additive.Naturality.Unknown -> nameView.setTextColor(context.resources.getColor(R.color.colorPrimaryDark));
                }
            }
        }
    }
}
