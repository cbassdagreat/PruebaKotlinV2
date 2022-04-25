package cbassdagreat.github.pruebakotlinv2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.InvalidationTracker
import cbassdagreat.github.pruebakotlinv2.R
import cbassdagreat.github.pruebakotlinv2.adapter.CryptoAdapter
import cbassdagreat.github.pruebakotlinv2.databinding.FragmentListaBinding
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem
import cbassdagreat.github.pruebakotlinv2.viewmodel.CryptoVM

class ListaFragment : Fragment() {

    lateinit var binding: FragmentListaBinding
    private val viewModel by activityViewModels<CryptoVM>()
    private val adapter = CryptoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater)

        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvLista.adapter = adapter
            rvLista.layoutManager = layoutManager
        }

        adapter.setMiListener(object : CryptoAdapter.MiListener{
            override fun miOnClick(cursosItem: CryptoMonedasItem) {
                viewModel.updateCrypto(cursosItem)
                Navigation.findNavController(requireView()).navigate(R.id.action_listaFragment_to_detalleFragment)
            }

        })

        viewModel.monedas.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        return binding.root
    }

}