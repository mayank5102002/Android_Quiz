package com.example.androidquiz.quizWonFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.databinding.QuizWonFragmentBinding

class QuizWonFragment : Fragment() {
    private lateinit var binding : QuizWonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuizWonFragmentBinding.inflate(layoutInflater)

        binding.playAgainButton.setOnClickListener {
            this.findNavController().navigate(QuizWonFragmentDirections.actionQuizWonFragmentToTitleFragment())
        }

        return binding.root
    }

}