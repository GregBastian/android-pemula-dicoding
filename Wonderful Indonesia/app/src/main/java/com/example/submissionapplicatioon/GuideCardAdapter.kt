package com.example.submissionapplicatioon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GuideCardAdapter internal constructor(private val listGuide: ArrayList<Guide>) : RecyclerView.Adapter<GuideCardAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_column_guides, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val guide = listGuide[position]

        Glide.with(holder.itemView.context)
            .load(guide.photo)
            .apply(RequestOptions().override(300, 300))
            .into(holder.guidePhoto)

        holder.guideName.text = guide.name

        holder.btnGuide.text = "BACA GUIDE " + guide.name

        holder.btnGuide.setOnClickListener { Toast.makeText(holder.itemView.context, "Feature Coming Soon", Toast.LENGTH_SHORT).show() }

        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Feature Coming Soon", Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int {
        return listGuide.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var guideName: TextView = itemView.findViewById(R.id.guide_name)
        var guidePhoto: ImageView = itemView.findViewById(R.id.img_guide_photo)
        var btnGuide : Button = itemView.findViewById(R.id.guide_button)
    }
}