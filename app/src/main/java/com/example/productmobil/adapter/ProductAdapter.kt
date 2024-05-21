package com.example.productmobil.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productmobil.R
import com.example.productmobil.databinding.ItemCountryBinding
import com.example.productmobil.model.Product
import com.example.productmobil.util.downloadURL

class ProductAdapter(private var countryList: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: ItemCountryBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country,parent,false)

        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.priceTV.text = countryList[position].price
        holder.view.descriptionTV.text = countryList[position].title

//        Glide.with(holder.view.root)
//            .load(countryList[position].flagUrl)
//            .into(holder.view.countryIV)
        holder.view.productIV.downloadURL(countryList[position].image)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Product>){
        countryList = newList as ArrayList<Product>
        notifyDataSetChanged()
    }
}