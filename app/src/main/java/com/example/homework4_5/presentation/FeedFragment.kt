package com.example.homework4_5.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework4_5.databinding.FragmentFeedBinding
import com.example.homework4_5.domain.model.FeedPost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint

class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private var _adapter: FeedAdapter? = null
    private val adapter get() = _adapter!!

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadData()
        setupUi()
    }


    private fun setupUi() {
        _adapter = FeedAdapter(
            commentOnClickListener = {
                findNavController().navigate(
                    FeedFragmentDirections.actionFragmentFeedToCommentFragment(
                        post = it
                    )
                )

            },
            likeOnClickListener = {
                viewModel.updateLike(it)
            }

        )
        binding.postRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.postRecyclerView.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.postRecyclerView.addItemDecoration(divider)

        lifecycleScope.launchWhenCreated {
            viewModel.feedUiState.collectLatest {
                when (it.loading) {
                    true -> binding.progressCircular.visibility = View.VISIBLE
                    false -> binding.progressCircular.visibility = View.GONE
                }

                when (it.data.isNotEmpty()) {
                    true -> {
                        adapter.setPosts(it.data)
                    }
                    false -> {

                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _adapter = null
        _binding = null
    }

}