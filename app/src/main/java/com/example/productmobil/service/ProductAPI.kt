package com.example.productmobil.service

import com.example.productmobil.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    fun getProducts():Call<List<Product>>


    //https://fakestoreapi.com/products
}