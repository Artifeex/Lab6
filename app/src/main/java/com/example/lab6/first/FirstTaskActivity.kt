package com.example.lab6.first

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab6.R

class FirstTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FirstTaskActivity::class.java)
    }
}