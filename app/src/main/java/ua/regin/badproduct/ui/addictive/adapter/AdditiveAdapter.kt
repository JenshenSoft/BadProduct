package ua.regin.badproduct.ui.addictive.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
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

    var filteredList: List<Additive>? = null;
        private set

    fun search(query: String) {
        filteredList = additiveList?.filter {
            it.synonym.contains(query, true)
                    || it.name.contains(query, true)
                    || it.similar.contains(query, false)
        };
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
        val similarView: TextView by bindView(R.id.similarView);
        val container: SquareLayout by bindView(R.id.container);
        val imageView: ImageView by bindView(R.id.imageView);

        fun bindAdditive(additive: Additive, function: () -> Unit) {
            itemView.setOnClickListener { function() }
            with(additive) {
                nameView.text = name;
                similarView.text = similar;
                Picasso.with(context).load(image).fit().centerCrop().into(imageView);
            }
        }
    }
}
