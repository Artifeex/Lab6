package com.example.lab6.fourth

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.lab6.databinding.ActivityFourthTaskBinding

class FourthTaskActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFourthTaskBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: FourthTaskViewModel
    private lateinit var adapter: CoinsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[FourthTaskViewModel::class.java]
        adapter = CoinsAdapter()
        binding.rvCoins.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.canUpdateCoinsLD.observe(this) {
            if(it) {
                adapter.coinsList = viewModel.coinInfo.coinsList
                binding.progressBar.visibility = View.GONE
            } else {

            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FourthTaskActivity::class.java)
    }
}