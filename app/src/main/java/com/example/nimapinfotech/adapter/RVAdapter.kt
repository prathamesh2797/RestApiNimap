package com.example.nimapinfotech.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nimapinfotech.databinding.ItemViewBinding
import com.example.nimapinfotech.models.Record

class RVAdapter(private val context: Context,
                private val record : List<Record>
): RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    inner class ViewHolder(var binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val currentItem= record[position]
            Glide.with(holder.itemView.rootView).load(currentItem.mainImageURL).into(ivImageView)
            tvTitle.text = currentItem.title.toString()
            tvDescription.text = currentItem.shortDescription.toString()
            tvTotalValueValue.text = currentItem.totalValue.toString()
            tvCollectedValueValue.text = currentItem.collectedValue.toString()
            tvStartDateValue.text = currentItem.startDate.toString()
            tvEndDateValue.text = currentItem.endDate.toString()
        }


    }

    override fun getItemCount(): Int {
        return record.size
    }


}
