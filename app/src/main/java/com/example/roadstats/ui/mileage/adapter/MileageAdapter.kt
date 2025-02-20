package com.example.roadstats.ui.mileage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roadstats.databinding.ItemMileageBinding
import com.example.roadstats.ui.mileage.modelUi.MileageUiModel

class MileageAdapter(private var mileageList: List<MileageUiModel>) :
    RecyclerView.Adapter<MileageAdapter.MileageViewHolder>() {

    class MileageViewHolder(private val binding: ItemMileageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mileage: MileageUiModel) {
            binding.dateTextView.text = mileage.date
            binding.distanceTextView.text = mileage.distance
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MileageViewHolder {
        val binding = ItemMileageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MileageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MileageViewHolder, position: Int) {
        holder.bind(mileageList[position])
    }

    override fun getItemCount(): Int = mileageList.size

    fun updateList(newList: List<MileageUiModel>) {
        mileageList = newList
        notifyDataSetChanged()
    }
}

