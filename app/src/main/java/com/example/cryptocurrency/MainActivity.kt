package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.cryptocurrency.api.CoinApi
import com.example.cryptocurrency.api.NetworkManager
import com.example.cryptocurrency.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCoins()

    }

    private fun getCoins(): List<Coin> {
        val coinsData = NetworkManager.getInstance().create(CoinApi::class.java)
        var coinsList = listOf<Coin>()
        lifecycleScope.launch {
            coinsList = coinsData.getCoins()
        }
        return coinsList
    }

//    runOnUiThread {
//        Picasso.get().load(country.flags.png).into(countryFlag)
//    }
}