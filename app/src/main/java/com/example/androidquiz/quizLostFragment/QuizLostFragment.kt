package com.example.androidquiz.quizLostFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.databinding.QuizLostFragmentBinding

class QuizLostFragment : Fragment() {
    private lateinit var binding : QuizLostFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuizLostFragmentBinding.inflate(layoutInflater)

        binding.retryButton.setOnClickListener {
            this.findNavController().navigate(QuizLostFragmentDirections.actionQuizLostFragmentToTitleFragment())
        }

        return binding.root
    }

}