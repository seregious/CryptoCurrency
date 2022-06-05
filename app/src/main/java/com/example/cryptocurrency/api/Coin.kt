package com.example.cryptocurrency

data class Coin (
    val id: String,
    val name: String,
    val image: String,
    val current_price: String,
    val price_change_24h: String,
    val last_updated: String
        )