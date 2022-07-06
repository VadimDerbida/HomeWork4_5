package com.example.homework4_5.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework4_5.databinding.FragmentCommentBinding

class CommentFragment : Fragment() {
    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentBinding.inflate(inflater)
        return binding.root
    }
}