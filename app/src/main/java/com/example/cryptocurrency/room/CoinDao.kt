package com.example.cryptocurrency.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptocurrency.Coin


@Dao
interface CoinDao {

    @Query("SELECT * FROM coins")
    fun getCoinList(): List<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoins(coins: List<CoinEntity>)
}