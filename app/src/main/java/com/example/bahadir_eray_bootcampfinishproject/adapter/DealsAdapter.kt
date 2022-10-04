package com.example.bahadir_eray_bootcampfinishproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bahadir_eray_bootcampfinishproject.data.model.travel.TravelsModel
import com.example.bahadir_eray_bootcampfinishproject.databinding.DealsItemsBinding
import com.example.bahadir_eray_bootcampfinishproject.util.downloadFromUrl
import com.example.bahadir_eray_bootcampfinishproject.util.placeholderProgressBar

class DealsAdapter(val hotelsList: MutableList<TravelsModel>) :
    RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {
    private lateinit var context: Context

    class DealsViewHolder(val dealsBinding: DealsItemsBinding) :
        RecyclerView.ViewHolder(dealsBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
        val dealsBinding =
            DealsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DealsViewHolder(dealsBinding)
    }

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        holder.dealsBinding.detalsImageItem.downloadFromUrl(
            hotelsList[position].images?.first()?.url,
            placeholderProgressBar(holder.itemView.context)
        )
    }

    override fun getItemCount(): Int {
        return hotelsList.count()
    }

}