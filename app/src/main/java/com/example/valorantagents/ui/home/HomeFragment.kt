package com.example.valorantagents.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantagents.data.network.IAgentApi
import com.example.valorantagents.data.network.model.Resource
import com.example.valorantagents.data.repository.NetworkRepository
import com.example.valorantagents.databinding.FragmentHomeBinding
import com.example.valorantagents.ui.adapter.AgentListAdapter
import com.example.valorantagents.ui.base.BaseFragment
import com.example.valorantagents.ui.viewmodel.HomeViewModel
import com.example.valorantagents.ui.viewmodel.HomeViewModelFactory
import com.example.valorantagents.util.visibleProgressBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var repository: NetworkRepository // Bu örnekte Repository'yi direkt aldığınızı varsayıyorum

    override fun getFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        // Accessing ViewModel methods
        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(NetworkRepository(IAgentApi()))
        ).get(HomeViewModel::class.java)

        with(binding.mainRecyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }

        collectAgent()
        viewModel.fechAgentFromNetwork()
        return view
    }


    private fun collectAgent() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchAgent.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                            binding.progressbar.visibleProgressBar(true)
                    }

                    is Resource.Success -> {
                        // Verileri işleyin
                        val result = withContext(Dispatchers.IO) {
                            viewModel.manipulateRawData(resource.value.data)
                        }
                            with(binding) {
                                progressbar.visibleProgressBar(false)
                                mainRecyclerView.adapter = AgentListAdapter(result)
                        }
                    }

                    is Resource.Failure -> {
                        // Hata durumunu göster
                        showErrorMessage(HomeContants.ERROR_MESSAGE)

                    }
                }

            }
        }
    }

    private fun showErrorMessage(errorMessage: String) {
            binding.progressbar.visibleProgressBar(false)
            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

}