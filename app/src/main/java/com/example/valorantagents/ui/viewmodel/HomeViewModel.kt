package com.example.valorantagents.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantagents.data.network.model.Agent
import com.example.valorantagents.data.network.model.Datum
import com.example.valorantagents.data.network.model.DisplayName
import com.example.valorantagents.data.network.model.Resource
import com.example.valorantagents.data.repository.NetworkRepository
import com.example.valorantagents.ui.adapter.AgentDisplayAttributes
import com.example.valorantagents.ui.adapter.ListOfAgentDisplayAttributes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _fetchAgent = MutableStateFlow<Resource<Agent>>(Resource.Loading)
    val fetchAgent: StateFlow<Resource<Agent>> get() = _fetchAgent.asStateFlow()

    fun fechAgentFromNetwork() {
        viewModelScope.launch(Dispatchers.IO) {
            _fetchAgent.value = networkRepository.getAgentsRepo()
        }
    }


    fun manipulateRawData(data: List<Datum>): List<ListOfAgentDisplayAttributes> {
        // todo bir fonksiyon sadece bir işlem yapmalı, bunu birkaç ayrı fonksiyona bölmelisin.

//        Controller,
//        Duelist,
//        Initiator,
//        Sentinel
        val controllerList: MutableList<AgentDisplayAttributes> = mutableListOf()
        val duelistList: MutableList<AgentDisplayAttributes> = mutableListOf()
        val initiatorList: MutableList<AgentDisplayAttributes> = mutableListOf()
        val sentinelList: MutableList<AgentDisplayAttributes> = mutableListOf()
        val uncertainList: MutableList<AgentDisplayAttributes> = mutableListOf()

        data.map { datum ->
            datum.role?.let { role ->

                val agentName = datum.displayName
                val agentImage = datum.displayIcon

                // değişkenlere atama yapılıyor,
                val (agentRole, targetList) = when (role.displayName) {
                    DisplayName.Controller -> "Controller" to controllerList
                    DisplayName.Duelist -> "Duelist" to duelistList
                    DisplayName.Initiator -> "Initiator" to initiatorList
                    DisplayName.Sentinel -> "Sentinel" to sentinelList
                    else -> "Uncertain" to uncertainList
                }

                val classifiedAgent = AgentDisplayAttributes(agentName, agentRole, agentImage)
                targetList.add(classifiedAgent)
            }
        }

//        val processedDataList = listOf(
//            ListOfAgentDisplayAttributes(controllerList, "Controller"),
//            ListOfAgentDisplayAttributes(duelistList, "Duelist"),
//            ListOfAgentDisplayAttributes(initiatorList, "Initiator"),
//            ListOfAgentDisplayAttributes(sentinelList, "Sentinel"),
//            ListOfAgentDisplayAttributes(uncertainList, "Uncertain")
//        )
        // todo listeye bir şeyler ekleyeceksen okunabilirlik açısından bu yöntem daha iyi

        return listOf(
            "Controller" to controllerList,
            "Duelist" to duelistList,
            "Initiator" to initiatorList,
            "Sentinel" to sentinelList,
            "Uncertain" to uncertainList
        ).map { (name, list) ->
            ListOfAgentDisplayAttributes(list, name)
        }
//        return processedDataList
    }

}