package com.example.lab6.fourth

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab6.fourth.network.ApiFactory
import com.example.lab6.fourth.network.ApiService
import com.example.lab6.fourth.network.pojo.CoinsInfoDto
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.lang.Exception

class FourthTaskViewModel(
    application: Application
): AndroidViewModel(application) {

    private val apiService = ApiFactory.service
    private val _canUpdateCoins: MutableLiveData<Boolean> = MutableLiveData()

    val canUpdateCoinsLD: LiveData<Boolean>
        get() = _canUpdateCoins

    var hasInternetConnection = MutableLiveData<Boolean>(true)

    init {
        viewModelScope.launch {
            try {
                coinInfo = apiService.getCoinInfo()
            } catch (e: Exception) {
                hasInternetConnection.value = false
            }
            if(hasInternetConnection.value != false) {
                _canUpdateCoins.value = true
            }
        }
    }

    var coinInfo: CoinsInfoDto? = null

}