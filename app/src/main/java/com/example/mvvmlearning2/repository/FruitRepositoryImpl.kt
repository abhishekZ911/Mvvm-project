package com.example.mvvmlearning2.repository

import android.util.Log
import com.example.mvvmlearning2.api.api
import com.example.mvvmlearning2.models.FruitResponseType
import com.example.mvvmlearning2.models.FruitResponseTypeItem
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor(
    private val api: api
) {

    private var _details = MutableStateFlow<FruitResponseTypeItem?>(null)

    val details: StateFlow<FruitResponseTypeItem?>
        get() = _details

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun getDetails(name: String){
        var job = GlobalScope.async {
            var response = api.getDetails(name)
            response
        }

        var result = job.await();
        if(result.body() != null && result.isSuccessful){
            _details.emit(result.body())
            Log.d("Abhishek", result.body().toString())
        }
    }
}