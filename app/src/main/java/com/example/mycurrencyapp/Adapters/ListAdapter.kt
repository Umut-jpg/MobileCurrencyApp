package com.example.mycurrencyapp.Adapters
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrencyapp.Model.Api
import com.example.mycurrencyapp.Model.ApiResponse
import com.example.mycurrencyapp.Model.CurrencyData
import com.example.mycurrencyapp.databinding.CalculatoradapterBinding

class ListAdapter (private val apiResponse: ApiResponse?): RecyclerView.Adapter<ListAdapter.CurrencyDataHolder>() {

    class CurrencyDataHolder (val binding: CalculatoradapterBinding) : RecyclerView.ViewHolder(binding.root){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDataHolder {
        val binding = CalculatoradapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CurrencyDataHolder(binding);
    }

    override fun getItemCount(): Int {
        return apiResponse?.getCurrencies()?.size ?: 0
    }

    override fun onBindViewHolder(holder: CurrencyDataHolder, position: Int) {

        if (apiResponse== null) {
            holder.binding.apply {
                Sales.text = "Veriler yükleniyor..."
                Buying.text = "Veriler yükleniyor..."
                unit.text = "Veriler yükleniyor..."
                cName.text = "Veriler yükleniyor..."
            }
        }
        else{
            val currencies = apiResponse.getCurrencies()
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

