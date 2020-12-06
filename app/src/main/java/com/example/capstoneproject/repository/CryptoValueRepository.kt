package com.example.capstoneproject.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.capstoneproject.api.CryptoValueApi
import com.example.capstoneproject.model.CryptoValue
import com.example.capstoneproject.service.CryptoValueApiService

class CryptoValueRepository {
    private val cryptoValueApiService: CryptoValueApiService = CryptoValueApi.createApi()

    private val _cryptoValue: MutableLiveData<CryptoValue> = MutableLiveData()

    val cryptoValue: LiveData<CryptoValue>
        get() = _cryptoValue

    suspend fun getAllCurrencies() {
        try {
            val result = withTimout(5_000) {
                cryptoValueApiService.getCryptoValues()
            }
            _cryptoValue.value = result
        } catch (error: Throwable) {
            throw CryptoValueRefreshError("Unable to refresh crypto value", error)
        }

    }

    class CryptoValueRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}