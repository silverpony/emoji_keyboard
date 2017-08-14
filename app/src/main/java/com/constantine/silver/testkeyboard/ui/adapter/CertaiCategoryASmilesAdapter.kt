package com.constantine.silver.testkeyboard.ui.adapter

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.constantine.silver.testkeyboard.R

import org.jetbrains.anko.*

class CertaiCategoryASmilesAdapter internal constructor(internal var objects: IntArray) : RecyclerView.Adapter<CertaiCategoryASmilesAdapter.ViewHolder>() {

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        val mainImage: ImageView = view.findViewById(1) as ImageView
        val gifPlaceholder: ImageView = view.findViewById(2) as ImageView
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = viewGroup.context.
            relativeLayout {
                imageView {
                    id = 1
                    adjustViewBounds = true
                }.lparams {
                    height = dip(64)
                    width = dip(64)
                    centerHorizontally()
                    centerVertically()
                }
                imageView {
                    id = 2
                }.lparams {
                    height = dip(24)
                    width = height
                    alignParentEnd()
                    alignParentTop()
                }
                layoutParams = ViewGroup.LayoutParams(dip(80), dip(80))
            }
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var myOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .fitCenter()
        Glide.with(holder.itemView.context)
                .load("file:///android_asset/categoryIcons/a${objects[position]}.png")
                .apply(myOptions)
                .into(holder.mainImage)
        when(objects[position]) {
            10, 11 -> Glide.with(holder.itemView.context).load(R.drawable.gif_icon).into(holder.gifPlaceholder)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int = objects.size
    
}
