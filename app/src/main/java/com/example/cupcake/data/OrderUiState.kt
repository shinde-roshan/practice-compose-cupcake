package com.example.cupcake.data

data class OrderUiState(
    var quantity: Int = 0,
    var flavor: String = "",
    var date: String = "",
    var price: String = "",
    var pickupOptions: List<String> = listOf()
)