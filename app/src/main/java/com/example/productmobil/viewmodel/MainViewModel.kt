package com.example.productmobil.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.productmobil.model.Product
import com.example.productmobil.service.ProductAPIService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel(){

    private val productAPI = ProductAPIService()

    val productData = MutableLiveData<List<Product>>()
    val productLoad = MutableLiveData<Boolean>()
    val productError = MutableLiveData<Boolean>()

    fun getDataFromAPI(){
        productLoad.value = true

        productAPI.getData().enqueue(object : retrofit2.Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                productData.value = response.body()
                productLoad.value = false
                productError.value = false
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                productLoad.value = false
                productError.value = true

            }

        })



    }


}