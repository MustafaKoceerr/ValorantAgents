package com.example.valorantagents.data.network.model

data class RecruitmentData (
    val counterID: String,
    val milestoneID: String,
    val milestoneThreshold: Long,
    val useLevelVpCostOverride: Boolean,
    val levelVpCostOverride: Long,
    val startDate: String,
    val endDate: String
)