package ua.regin.badproduct.ui.addictive.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ua.regin.badproduct.R
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.addictive.view.SquareLayout
import ua.regin.badproduct.util.knife.bindView

class AdditiveAdapter(val context: Context, val onClick: (position: Int) -> Unit) : RecyclerView.Adapter<AdditiveAdapter.ViewHolder>() {

    var additiveList: List<Additive>? = null;
        set(value) {
            field = value;
            notifyDataSetChanged();
            filteredList = additiveList;
        }

    private var filteredList: List<Additive>? = null;

    fun search(query: String) {
        filteredList = additiveList?.filter { it.synonym.contains(query, true) || it.name.contains(query, true) };
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AdditiveAdapter.ViewHolder? {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_additive, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount() = filteredList?.size ?: 0;

    override fun onBindViewHolder(holder: AdditiveAdapter.ViewHolder?, position: Int) {
        holder?.bindAdditive(filteredList!![position], { onClick(position) });
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameView: TextView by bindView(R.id.nameView);
        val container: SquareLayout by bindView(R.id.container);

        fun bindAdditive(additive: Additive, function: () -> Unit) {
            itemView.setOnClickListener { function() }
            with(additive) {
                nameView.text = name;
                container.setCardBackgroundColor(ContextCompat.getColor(context, if (danger < 2) R.color.colorPrimaryGreen else R.color.colorPrimaryRed));
            }
        }
    }
}
