package cbassdagreat.github.pruebakotlinv2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cbassdagreat.github.pruebakotlinv2.R
import cbassdagreat.github.pruebakotlinv2.databinding.FragmentDetalleBinding
import cbassdagreat.github.pruebakotlinv2.viewmodel.CryptoVM
import com.squareup.picasso.Picasso


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
                Picasso.get().load(it.iconUrl).into(ivPicCrypto)
                tvAcrDetail.text = it.symbol
                tvMktCap.text = it.maxSupply.toString()
                tvSupply.text = it.maxSupply.toString()
                tvName.text = it.nameFull
                tvTime.text = it.name
                tvXRDetail.text = it.maxSupply.toString()

            }
        })
        return binding.root
    }

}