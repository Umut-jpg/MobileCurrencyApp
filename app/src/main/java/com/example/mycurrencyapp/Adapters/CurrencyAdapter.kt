package com.example.mycurrencyapp.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrencyapp.Model.ApiResponse
import com.example.mycurrencyapp.databinding.CurrencyCalculatorAdapterBinding
import com.example.mycurrencyapp.databinding.FragmentCalculateBinding

class CurrencyAdapter (private val apiResponse: ApiResponse? ,  private val fragment: Fragment): RecyclerView.Adapter<CurrencyAdapter.CurrencyDataHolder>() {
    var total : Double= 0.00;
    class CurrencyDataHolder(val binding: CurrencyCalculatorAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDataHolder {
        val binding = CurrencyCalculatorAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyDataHolder(binding);
    }

    override fun getItemCount(): Int {
         return apiResponse?.getCurrencies()?.size ?: 0
    }

    override fun onBindViewHolder(holder: CurrencyDataHolder, position: Int) {

        if (apiResponse== null) {
            holder.binding.apply {
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
                Buying.text = "${currency.value.CurrencyBuying}"
                unit.text = "${currency.key} ( ${currency.value.CurrencyName} )"
                cName.text= "${currency.key} Değişim: ${currency.value.change}"
            }
        }

        holder.binding.number.setText("0");
        holder.binding.posbutton.setOnClickListener {
            val buyingText = holder.binding.Buying.text.toString().replace(",",".")
            if(buyingText.isNotEmpty()) {
                val number = holder.binding.number.text.toString().toInt()
                val newnumber = number + 1
                holder.binding.number.text = newnumber.toString()
                total += buyingText.toDoubleOrNull() ?: 0.0
                total = String.format("%.2f", total).toDouble()
                textFragment();
            }
        }

        holder.binding.negbutton.setOnClickListener {
            val buyingText = holder.binding.Buying.text.toString().replace(",",".")
            if(buyingText.isNotEmpty() && holder.binding.number.text.toString().toInt() > 0) {
                val number = holder.binding.number.text.toString().toInt()
                val newnumber = number - 1
                holder.binding.number.text = newnumber.toString()
                total -= buyingText.toDoubleOrNull() ?: 0.0
                total = String.format("%.2f", total).toDouble()
                textFragment();
            }
        }

    }

    private fun textFragment() {
        val fragmentBinding = FragmentCalculateBinding.bind(fragment.requireView())
        fragmentBinding.restext.text =  "$total.TL"

    }



}