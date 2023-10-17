package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6.databinding.ActivityMainBinding
import com.example.lab6.fifth.FifthTaskActivity
import com.example.lab6.first.FirstTaskActivity
import com.example.lab6.fourth.FourthTaskActivity
import com.example.lab6.second.SecondTaskActivity
import com.example.lab6.seventh.SeventhTaskActivity
import com.example.lab6.sixth.SixthTaskActivity
import com.example.lab6.third.ThirdTaskActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListenersToButtons()
    }

    private fun setListenersToButtons() {
        binding.bnTask1.setOnClickListener {
            startActivity(FirstTaskActivity.newIntent(this))
        }
        binding.bnTask2.setOnClickListener {
            startActivity(SecondTaskActivity.newIntent(this))
        }
        binding.bnTask3.setOnClickListener {
            startActivity(ThirdTaskActivity.newIntent(this))
        }
        binding.bnTask4.setOnClickListener {
            startActivity(FourthTaskActivity.newIntent(this))
        }
        binding.bnTask5.setOnClickListener {
            startActivity(FifthTaskActivity.newIntent(this))
        }
        binding.bnTask6.setOnClickListener {
            startActivity(SixthTaskActivity.newIntent(this))
        }
        binding.bnTask7.setOnClickListener {
            startActivity(SeventhTaskActivity.newIntent(this))
        }
    }
}