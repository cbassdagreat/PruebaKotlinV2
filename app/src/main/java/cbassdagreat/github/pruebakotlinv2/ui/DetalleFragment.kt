package cbassdagreat.github.pruebakotlinv2.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import cbassdagreat.github.pruebakotlinv2.R
import cbassdagreat.github.pruebakotlinv2.databinding.FragmentDetalleBinding
import cbassdagreat.github.pruebakotlinv2.viewmodel.CryptoVM
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


class DetalleFragment : Fragment() {

    lateinit var binding: FragmentDetalleBinding
    private val viewModel by activityViewModels<CryptoVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        viewModel.moneda.observe(viewLifecycleOwner, Observer {
            with(binding)
            {
                var icon: String? = it.symbol?.lowercase()
                Picasso.get().load("https://static.coincap.io/assets/icons/$icon@2x.png").resize(300,300).into(ivPicCrypto)
                tvAcrDetail.text = it.symbol
                tvMktCap.text = it.marketCapUsd?.substring(0,8)
                tvSupply.text = it.maxSupply?.substring(0,8)
                tvName.text = it.name
                tvTime.text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date()).toString()
                tvXRDetail.text = it.priceUsd?.substring(0,8)


                btnVolver.setOnClickListener {
                    Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_listaFragment)
                }

            }
        })
        return binding.root
    }

}