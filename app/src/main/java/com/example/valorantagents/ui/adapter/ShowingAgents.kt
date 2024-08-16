package com.example.valorantagents.ui.adapter

import com.example.valorantagents.data.network.model.DisplayName

data class AgentDisplayAttributes(
    val agentName: String? = null,
    val agentRoleName: String? = null,
    val agentImage: String? = null
)

data class ListOfAgentDisplayAttributes(
    val agent: List<AgentDisplayAttributes>? = null,
    val agentRoleName: String,
)