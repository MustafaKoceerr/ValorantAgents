package com.example.valorantagents.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantagents.R

class AgentListAdapter(private val outAgentList: List<ListOfAgentDisplayAttributes>) :
    RecyclerView.Adapter<AgentListAdapter.AgentListViewHolder>() {

    inner class AgentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindOutRecycler(agentRow: ListOfAgentDisplayAttributes) {
            val recyclerView = itemView.findViewById<RecyclerView>(R.id.rowAgentRecyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            if (!agentRow.agent.isNullOrEmpty()) {
                recyclerView.adapter = AgentAdapter(agentRow.agent)
                itemView.findViewById<TextView>(R.id.rowAgentTitle).text = agentRow.agentRoleName
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.agent_recycler_row, parent, false)
        return AgentListViewHolder(view)
    }

    override fun getItemCount(): Int = outAgentList.size

    override fun onBindViewHolder(holder: AgentListViewHolder, position: Int) {
        holder.bindOutRecycler(outAgentList[position])
    }
}