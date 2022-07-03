package com.sanatndermobile.simulatorsportheca.domain

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("descricao")
    val description: String,
    @SerializedName("grupo")
    val group: String,
    @SerializedName("local")
    val place: Place,
    @SerializedName("mandante")
    val homeTeam: Team,
    @SerializedName("visitante")
    val awayTeam: Team
)
