package cbassdagreat.github.pruebakotlinv2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.pruebakotlinv2.R
import cbassdagreat.github.pruebakotlinv2.databinding.ItemLayoutBinding
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem
import com.squareup.picasso.Picasso

class CryptoAdapter  : RecyclerView.Adapter<CryptoAdapter.CustomViewHolder>()
{
    class CustomViewHolder(itemView: View, val listener: MiListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(cryptoMonedasItem: CryptoMonedasItem)
        {
            with(binding)
            {
                Picasso.get().load(cryptoMonedasItem.iconUrl).resize(50,50).into(ivSymbol)
                tvAcr.text = cryptoMonedasItem.symbol
                tvXR.text = cryptoMonedasItem.maxSupply.toString()

                itemView.setOnClickListener {
                    listener.miOnClick(cryptoMonedasItem)
                }

            }
        }
    }

    var lista:List<CryptoMonedasItem> = CryptoMonedas()
    lateinit var listener: MiListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(moneda: CryptoMonedas)
    {
        lista = moneda
        notifyDataSetChanged()
    }

    interface MiListener{
        fun miOnClick(cursosItem: CryptoMonedasItem)
    }

   fun setMiListener(listener: MiListener)
    {
        this.listener = listener
    }
}