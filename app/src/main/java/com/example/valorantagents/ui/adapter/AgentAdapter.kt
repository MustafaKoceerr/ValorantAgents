package com.example.valorantagents.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valorantagents.databinding.AgentItemRowBinding
// icerideki row horizontal olarak listeleme yapacak
class AgentAdapter(private val agentList: List<AgentDisplayAttributes>) :
    RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    inner class AgentViewHolder(val binding: AgentItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindInnerRecyclerData(bindAgent: AgentDisplayAttributes) {
            binding.rowTextName.text = bindAgent.agentName
            Glide.with(binding.rowCard.context) // Glide ile bağlama
                .load(bindAgent.agentImage) // Resim URL'si veya kaynağı
                .into(binding.rowImageView) // Resmin yükleneceği ImageView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val binding =
            AgentItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentViewHolder(binding)
    }

    override fun getItemCount(): Int = agentList.size

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        with(holder.binding.root){
            val itemWidth =
                (context.resources.displayMetrics.widthPixels * (0.40)).toInt()
            layoutParams.width = itemWidth
            // her bir row'un with'ini 40/100'üne eşit olacak şekilde ayarladık.
        }

        holder.bindInnerRecyclerData(agentList[position])
    }


}