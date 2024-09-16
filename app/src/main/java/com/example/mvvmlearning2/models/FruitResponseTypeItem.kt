package com.example.mvvmlearning2.models

import kotlinx.coroutines.flow.MutableStateFlow

data class FruitResponseTypeItem(
    val family: String,
    val genus: String,
    val id: Int,
    val name: String,
    val nutritions: Nutritions,
    val order: String
)