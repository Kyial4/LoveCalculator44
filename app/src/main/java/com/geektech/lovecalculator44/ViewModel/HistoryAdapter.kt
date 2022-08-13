package com.geektech.lovecalculator44.ViewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lovecalculator44.Model.LoveModel
import com.geektech.lovecalculator44.databinding.ItemHistoryBinding

class HistoryAdapter(private var list: List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class HistoryViewHolder(private val binding:ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.firstName.text = loveModel.firstName
            binding.secondName.text = loveModel.secondName
        }

    }
}