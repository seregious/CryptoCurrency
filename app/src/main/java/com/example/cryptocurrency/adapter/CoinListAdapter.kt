package com.example.cryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.ItemCoinInfoBinding
import com.example.cryptocurrency.room.CoinEntity
import com.squareup.picasso.Picasso

class CoinListAdapter(private val listener: OnCoinClickListener): RecyclerView.Adapter<CoinListAdapter.CoinInfoViewHolder>() {

    var coinList: List<CoinEntity> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class CoinInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var binding = ItemCoinInfoBinding.bind(itemView)

        fun bind(coin: CoinEntity, listener: OnCoinClickListener) = with(binding){
            coinName.text = coin.name
            currentPrice.text = "Current price " + coin.current_price  + " USD"
            price24h.text = "Change in 24h " + coin.price_change_24h + " USD"
            Picasso.get().load(coin.image).into(coinImage)

            itemView.setOnClickListener {
                listener.onCoinClick(coin)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        holder.bind(coinList[position], listener)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    interface OnCoinClickListener {
        fun onCoinClick(coin: CoinEntity)
    }
}