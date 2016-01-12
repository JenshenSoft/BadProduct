package ua.regin.badproduct.ui.addictive.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_additive.view.*
import ua.regin.badproduct.R
import ua.regin.badproduct.entity.Additive

class AdditiveAdapter(val context: Context) : RecyclerView.Adapter<AdditiveAdapter.ViewHolder>() {

    var additiveList: List<Additive>? = null;
        set(value) {
            field = value;
            notifyDataSetChanged();
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdditiveAdapter.ViewHolder? {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_additive, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return additiveList?.size ?: 0;
    }

    override fun onBindViewHolder(holder: AdditiveAdapter.ViewHolder?, position: Int) {
        holder?.bindAdditive(additiveList!![position]);
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindAdditive(additive: Additive) {
            with(additive) {
                itemView.nameView.text = name;
                itemView.similarView.text = similar;
                itemView.dangerView.setDangerCount(danger!!);

                when (naturality) {
                    "natural" -> itemView.nameView.setTextColor(context.resources.getColor(android.R.color.holo_green_dark));
                }

            }
        }
    }
}
