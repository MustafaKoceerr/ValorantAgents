package com.example.valorantagents.data.repository

import com.example.valorantagents.data.network.IAgentApi
import com.example.valorantagents.data.network.model.Agent
import com.example.valorantagents.data.network.model.Resource

class NetworkRepository(
    private val api: IAgentApi
) : BaseRepository() {
    // ################ Network Operations ################

    suspend fun getAgentsRepo(): Resource<Agent> {
        return safeApiCall {
            api.getAgents()
        }
    }

//    suspend fun getAgentsRepo2(): Resource<Agent> = safeApiCall {
//        api.getAgents()
//    }
}