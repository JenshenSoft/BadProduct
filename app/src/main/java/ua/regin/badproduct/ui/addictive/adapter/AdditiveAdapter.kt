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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameView: TextView by bindView(R.id.nameView);
        val similarView: TextView by bindView(R.id.similarView);
        val dangerView: DangerView by bindView(R.id.dangerView);

        fun bindAdditive(additive: Additive) {
            with(additive) {
                nameView.text = context.getString(R.string.additive_item_title, name, similar);
                similarView.text = synonym;
                dangerView.setDangerCount(danger!!);

                when (naturality) {
                    Additive.Naturality.Natural -> nameView.setTextColor(context.resources.getColor(android.R.color.holo_green_dark));
                    Additive.Naturality.Synthetic -> nameView.setTextColor(context.resources.getColor(android.R.color.holo_red_dark));
                    Additive.Naturality.Unknown -> nameView.setTextColor(context.resources.getColor(android.R.color.holo_orange_dark));
                }
            }
        }
    }

    public interface OnClick {
        fun onClick();
    }
}
