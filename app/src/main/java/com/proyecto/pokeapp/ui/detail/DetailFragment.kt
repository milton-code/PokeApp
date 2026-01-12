package com.proyecto.pokeapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.proyecto.pokeapp.R
import com.proyecto.pokeapp.ui.AppViewModelProvider
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels { AppViewModelProvider.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val flavorTextView = view.findViewById<TextView>(R.id.flavor_text)

        arguments?.getString("abilityUrl")?.let {
            viewModel.loadDetails(it)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.flavorText.collect { flavorText ->
                    flavorTextView.text = flavorText ?: "Cargando descripción..."
                }
            }
        }
    }
}