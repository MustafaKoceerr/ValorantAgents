package com.example.valorantagents.data.network.model

data class Datum (
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val characterTags: List<String>? = null,
    val displayIcon: String,
    val displayIconSmall: String,
    val bustPortrait: String? = null,
    val fullPortrait: String? = null,
    val fullPortraitV2: String? = null,
    val killfeedPortrait: String,
    val background: String? = null,
    val backgroundGradientColors: List<String>,
    val assetPath: String,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val role: Role? = null,
    val recruitmentData: RecruitmentData? = null,
    val abilities: List<Ability>,
    val voiceLine: Any? = null
)