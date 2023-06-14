package com.example.rick_and_morty.feature_location.domain.models

import com.example.rick_and_morty.feature_location.data.dto.Result

data class DomainResult(
    val id: Int,
    val name: String,
    val type: String

)

fun Result.toDomainResult():DomainResult{
    return DomainResult(id, name, type)
}
