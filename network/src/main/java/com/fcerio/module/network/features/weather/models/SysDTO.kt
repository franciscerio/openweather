package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.Sys

data class SysDTO(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

fun SysDTO.toDomain(): Sys {
    return with(this) {
        Sys(
            type = type,
            id = id,
            country =
            country,
            sunrise = sunrise,
            sunset = sunset
        )
    }
}