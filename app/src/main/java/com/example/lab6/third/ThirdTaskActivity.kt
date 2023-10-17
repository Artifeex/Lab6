package com.example.lab6.third

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.example.lab6.R
import com.example.lab6.databinding.ActivityThirdTaskBinding
import com.example.lab6.second.SecondTaskActivity

class ThirdTaskActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityThirdTaskBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addItemsToList()
    }

    private fun addItemsToList() {
        val tvViewWhite = TextView(this)
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val dpMargins = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            5.0f,
            resources.displayMetrics
        ).toInt()
        params.setMargins(dpMargins)
        val dpPadding= TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            20.0f,
            resources.displayMetrics
        ).toInt()

        tvViewWhite.layoutParams = params
        tvViewWhite.text = "Белый"
        tvViewWhite.textSize = 17.0f

        tvViewWhite.setPadding(dpPadding)
        tvViewWhite.gravity = Gravity.CENTER
        tvViewWhite.setBackgroundColor(getColor(R.color.white))
        binding.linearLayoutThird.addView(tvViewWhite)

        val tvViewBlack = TextView(this)
        tvViewBlack.layoutParams = params
        tvViewBlack.text = "Черный"
        tvViewBlack.textSize = 17.0f
        tvViewBlack.setTextColor(getColor(R.color.white))

        tvViewBlack.setPadding(dpPadding)
        tvViewBlack.gravity = Gravity.CENTER
        tvViewBlack.setBackgroundColor(getColor(R.color.black))
        binding.linearLayoutThird.addView(tvViewBlack)

        val tvViewRed = TextView(this)
        tvViewRed.layoutParams = params
        tvViewRed.text = "Красный"
        tvViewRed.textSize = 17.0f
        tvViewRed.setTextColor(getColor(R.color.white))

        tvViewRed.setPadding(dpPadding)
        tvViewRed.gravity = Gravity.CENTER
        tvViewRed.setBackgroundColor(getColor(android.R.color.holo_red_light))
        binding.linearLayoutThird.addView(tvViewRed)

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, ThirdTaskActivity::class.java)
    }

}