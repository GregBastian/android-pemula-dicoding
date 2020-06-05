package com.example.submissionapplicatioon

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class ListAdapter(private val listMountain: ArrayList<Mountain>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_mountain_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_mountain_location)
        var imgPhoto: ImageView = itemView.findViewById(R.id.mountain_photo)
        var btnSeeDetail: Button = itemView.findViewById(R.id.btn_lihat_detail)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_mountain, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMountain.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val mountain = listMountain[position]
        Glide.with(holder.itemView.context)
            .load(mountain.photo)
            .apply(RequestOptions().override(620, 400))
            .into(holder.imgPhoto)
        holder.tvName.text = mountain.name
        holder.tvDetail.text = mountain.location

        holder.btnSeeDetail.setOnClickListener {
            val context= holder.btnSeeDetail.context
            val mountainDetailActivity = Intent(context, MountainDetail::class.java)
            mountainDetailActivity.putExtra(MountainDetail.DATA_NAMA, mountain.name)
            mountainDetailActivity.putExtra(MountainDetail.DATA_LOKASI, mountain.location)
            mountainDetailActivity.putExtra(MountainDetail.DATA_GAMBAR, mountain.photo)
            context.startActivity(mountainDetailActivity)
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Mountain)
    }
}