package com.example.homework4_5.presentation

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.homework4_5.databinding.FragmentCommentBinding
import java.time.LocalDate

class CommentFragment : Fragment() {
    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<CommentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentCommentBinding.inflate(inflater)
        return binding.root
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}