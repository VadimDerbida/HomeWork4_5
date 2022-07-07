package com.example.homework4_5.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework4_5.databinding.FragmentCommentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CommentFragment : Fragment() {
    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!

    private var _adapter: CommentAdapter? = null
    private val adapter get() = _adapter!!

    private val viewModel: FeedViewModel by viewModels()

    private val args by navArgs<CommentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentCommentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        adapter.setComments(args.post.comments)
    }

    private fun setupUi() {
        _adapter = CommentAdapter() {

        }
        binding.commentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.commentRecyclerView.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.commentRecyclerView.addItemDecoration(divider)

        //val divider1 = DividerItemDecoration(requireContext(), LinearLayoutManager.HORIZONTAL)
        //binding.commentRecyclerView.addItemDecoration(divider1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _adapter = null
        _binding = null
    }
}