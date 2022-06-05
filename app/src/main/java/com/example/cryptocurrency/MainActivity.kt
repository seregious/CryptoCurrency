package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cryptocurrency.api.CoinApi
import com.example.cryptocurrency.api.NetworkManager
import com.example.cryptocurrency.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        setContentView(binding.root)

            viewModel.loadData()
            viewModel.list.observe(this@MainActivity, Observer {
                Log.d("test loading data", it[0].name)
            })



    }

//    runOnUiThread {
//        Picasso.get().load(country.flags.png).into(countryFlag)
//    }
}