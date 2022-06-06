package com.example.cryptocurrency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cryptocurrency.adapter.CoinListAdapter
import com.example.cryptocurrency.api.CoinApi
import com.example.cryptocurrency.api.NetworkManager
import com.example.cryptocurrency.databinding.ActivityMainBinding
import com.example.cryptocurrency.room.CoinEntity
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity(), CoinListAdapter.OnCoinClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CoinViewModel
    private val adapter = CoinListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        setContentView(binding.root)
        binding.rcCoinList.adapter = adapter

        viewModel.list.observe(this, Observer {
            adapter.coinList = it
        })

    }

    override fun onCoinClick(coin: CoinEntity) {
        startActivity(Intent(this, DetailedInfo::class.java).apply {
            putExtra("coin", coin)
        })
    }
}