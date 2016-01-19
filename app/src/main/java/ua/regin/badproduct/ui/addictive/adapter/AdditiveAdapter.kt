package ua.regin.badproduct.ui.addictive.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive
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
        filteredList = additiveList!!.filter { it.synonym.contains(query, true) || it.name.contains(query, true) };
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdditiveAdapter.ViewHolder? {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_additive, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount() = filteredList?.size ?: 0;

    override fun onBindViewHolder(holder: AdditiveAdapter.ViewHolder?, position: Int) {
        holder?.bindAdditive(filteredList!![position], onClick);
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameView: TextView by bindView(R.id.nameView);
        val container: View by bindView(R.id.container);

        fun bindAdditive(additive: Additive, function: (additive: Additive) -> Unit) {
            itemView.setOnClickListener { function(additive) }
            with(additive) {
                nameView.text = name;

                when (naturality) {
                    Additive.Naturality.Natural -> container.setBackgroundResource(R.color.colorPrimaryGreen);
                    Additive.Naturality.Synthetic -> container.setBackgroundResource(R.color.colorPrimaryRed);
                    Additive.Naturality.Unknown -> container.setBackgroundResource(R.color.colorPrimary);
                }
            }
        }
    }
}
