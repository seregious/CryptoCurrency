package com.example.cryptocurrency.api

import com.example.cryptocurrency.Coin
import com.example.cryptocurrency.room.CoinEntity
import retrofit2.http.GET

interface CoinApi {
        @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1&sparkline=false&price_change_percentage=24h")
        suspend fun getCoins() : List<CoinEntity>
}