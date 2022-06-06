package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptocurrency.databinding.ActivityDetailedInfoBinding
import com.example.cryptocurrency.room.CoinEntity
import com.squareup.picasso.Picasso

class DetailedInfo : AppCompatActivity() {
    lateinit var binding: ActivityDetailedInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedInfoBinding.inflate((layoutInflater))
        setContentView(binding.root)
        val coin = intent.getSerializableExtra("coin") as CoinEntity
        setData(coin)
    }

    private fun setData(coin: CoinEntity) = with(binding) {
        detailedCoinName.text = coin.name
        detailedCoinPrice.text = "Current price " + coin.current_price  + " USD"
        detailedPriceChange.text = "Change in 24h " + coin.price_change_24h + " USD"
        lastUpdate.text = coin.last_updated
        Picasso.get().load(coin.image).into(detailedCoinImage)
    }
}