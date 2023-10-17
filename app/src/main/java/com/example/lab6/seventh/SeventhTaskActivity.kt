package com.example.lab6.seventh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.TextView
import com.example.lab6.R
import com.example.lab6.databinding.ActivitySixthTaskBinding
import com.example.lab6.second.SecondTaskActivity

class SeventhTaskActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySixthTaskBinding.inflate(layoutInflater)
    }

    private lateinit var spEditText: SharedPreferences
    private lateinit var spCheckBox: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        spEditText = getSharedPreferences(SP_NAME_ET, MODE_PRIVATE)
        spCheckBox = getSharedPreferences(SP_NAME_CB, MODE_PRIVATE)


        binding.etSharedPref.setText(spEditText.getString(ET_NAME, null))
        binding.cbSharedPref.isChecked = spCheckBox.getBoolean(CB_CHECKED, false)
        
        binding.etSharedPref.afterTextChangedDelayed {
            val editor = spEditText.edit()
            editor.apply {
                putString(ET_NAME, binding.etSharedPref.text.toString())
                apply()
            }
        }


        binding.cbSharedPref.setOnCheckedChangeListener {
                _, isChecked ->
                val editor = spCheckBox.edit()
                editor.apply {
                    putBoolean(CB_CHECKED, isChecked)
                    apply()
                }
        }
    }

    fun TextView.afterTextChangedDelayed(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            var timer: CountDownTimer? = null

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                timer?.cancel()
                timer = object : CountDownTimer(1000, 1500) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        afterTextChanged.invoke(editable.toString())
                    }
                }.start()
            }
        })
    }

    companion object {
        private const val SP_NAME_ET = "shared_pref_et"
        private const val SP_NAME_CB = "shared_pref_cb"
        private const val ET_NAME = "et_name"
        private const val CB_CHECKED = "cd_checked"


        fun newIntent(context: Context) = Intent(context, SeventhTaskActivity::class.java)


    }
}