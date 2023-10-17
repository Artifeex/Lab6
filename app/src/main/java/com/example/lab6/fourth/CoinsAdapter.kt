package com.example.lab6.fourth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.databinding.CoinInfoItemBinding
import com.example.lab6.fourth.network.pojo.CoinInfo

class CoinsAdapter: RecyclerView.Adapter<CoinsAdapter.CoinViewHolder>() {

    var coinsList: List<CoinInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinsList[position]
        holder.binding.tvCoinName.text = coin.name
        holder.binding.tvCoinPrice.text = coin.value.toString()
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    inner class CoinViewHolder(
        val binding: CoinInfoItemBinding
    ): RecyclerView.ViewHolder(binding.root)

}