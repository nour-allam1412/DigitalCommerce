package com.depi.myapplicatio.data.models

data class Categories(
    val title: String,
    val products: Int? = null,
    val image: String,
    val rank: Int? = null
) {
}