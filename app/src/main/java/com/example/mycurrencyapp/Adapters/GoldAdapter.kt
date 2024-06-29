package com.example.mycurrencyapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrencyapp.Model.ApiResponse
import com.example.mycurrencyapp.databinding.CalculatoradapterBinding

class GoldAdapter (private val apiResponseGold: ApiResponse?): RecyclerView.Adapter<GoldAdapter.GoldDataHolder>() {

    class GoldDataHolder (val binding: CalculatoradapterBinding) : RecyclerView.ViewHolder(binding.root){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldDataHolder {
        val binding = CalculatoradapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GoldDataHolder(binding);
    }

    override fun getItemCount(): Int {
       return  apiResponseGold?.getGolds()?.size ?: 0

    }

    override fun onBindViewHolder(holder: GoldDataHolder, position: Int) {
        if (apiResponseGold == null) {
            holder.binding.apply {
                Sales.text = "Veriler yükleniyor..."
                Buying.text = "Veriler yükleniyor..."
                unit.text = "Veriler yükleniyor..."
                cName.text = "Veriler yükleniyor..."
            }
        }
        else{
            val currencies = apiResponseGold.getGolds()
            val currencyList = currencies.entries.toList()
            val currency = currencyList[position]
            holder.binding.apply {
                Sales.text = "${currency.value.CurrencySales}"
                Buying.text = "${currency.value.CurrencyBuying}"
                unit.text = "${currency.key} ( ${currency.value.CurrencyName} )"
                cName.text= "${currency.key} Değişim: ${currency.value.change}"
            }
        }

    }
}