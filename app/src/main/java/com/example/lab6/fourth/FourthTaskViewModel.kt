package com.example.lab6.fourth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab6.fourth.network.ApiFactory
import com.example.lab6.fourth.network.ApiService
import com.example.lab6.fourth.network.pojo.CoinsInfoDto
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class FourthTaskViewModel: ViewModel() {

    private val apiService = ApiFactory.service

    private val _canUpdateCoins: MutableLiveData<Boolean> = MutableLiveData()
    val canUpdateCoinsLD: LiveData<Boolean>
        get() = _canUpdateCoins

    init {
        viewModelScope.launch {
            coinInfo = apiService.getCoinInfo()
            _canUpdateCoins.value = true
        }
    }

    lateinit var coinInfo: CoinsInfoDto

}