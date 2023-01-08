package com.example.androidquiz.titleFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.androidquiz.databinding.TitleFragmentBinding
import com.example.androidquiz.quizFragment.QuizViewModel

class TitleFragment : Fragment() {
    private lateinit var binding : TitleFragmentBinding

    private lateinit var playButton : Button

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TitleFragmentBinding.inflate(layoutInflater)

        playButton = binding.playButton

        playButton.setOnClickListener {
            viewModel.getQuestions()
            view?.findNavController()?.navigate(TitleFragmentDirections.actionTitleFragmentToQuizFragment())
        }

        return binding.root
    }

}