package com.example.cryptocurrency

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.cryptocurrency.api.CoinApi
import com.example.cryptocurrency.api.NetworkManager
import com.example.cryptocurrency.room.AppDatabase
import com.example.cryptocurrency.room.CoinEntity
import kotlinx.coroutines.launch
import retrofit2.create

class CoinViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "coins").build()

    val list = db.coinDao().getCoinList()

    fun loadData() {
        val coinsData = NetworkManager.getInstance().create(CoinApi::class.java)
        var coinsList = listOf<CoinEntity>()
        viewModelScope.launch {
            coinsList = coinsData.getCoins()
            db.coinDao().insertCoins(coinsList)
            Log.d("test loading data", "Hi ${coinsList[0].name}")
        }


    }
}