package com.example.cryptocurrency.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "coins")

data class CoinEntity (
    @PrimaryKey val id: String,
    val name: String,
    val image: String,
    val current_price: String,
    val price_change_24h: String,
    val last_updated: String
): Serializable

//{
//    fun getCoin(): Coin = Coin (
//        id = id,
//        name = name,
//        image = image,
//        current_price = current_price,
//        price_change_24h = price_change_24h,
//        last_updated = last_updated
//            )
//    companion object {
//        fun loadData(coin: Coin): CoinEntity = CoinEntity(
//            id = coin.id,
//            name = coin.name,
//            image = coin.image,
//            current_price =  coin.current_price,
//            price_change_24h = coin.price_change_24h,
//            last_updated = coin.last_updated
//        )
//    }
//}