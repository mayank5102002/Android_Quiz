package com.example.androidquiz.quizFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidquiz.R
import com.example.androidquiz.databinding.QuizFragmentBinding

class QuizFragment : Fragment() {

    private lateinit var binding : QuizFragmentBinding

    lateinit var currentQuestion : Question
    private var numQuestions =  3
    lateinit var options : List<String>

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuizFragmentBinding.inflate(layoutInflater)

        validateQuestion()

        binding.quiz = this
        binding.questionRadioGroup.clearCheck()

        binding.submitButton.setOnClickListener {
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            if(checkedId != -1){
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                if(options[answerIndex] == currentQuestion.correctAnswer){
                    viewModel.incrementQuestion()

                    if(viewModel.questionNumber >= numQuestions){
                        //Go to win page
                        this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToQuizWonFragment())
                    } else {
                        this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentSelf())
                    }
                } else {
                    //Go to lose page
                    this.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToQuizLostFragment())
                }
            }
        }

        return binding.root
    }

    private fun validateQuestion(){
        binding.questionNumber.text = getString(R.string.question_number, viewModel.questionNumber+1, numQuestions)

        viewModel.getQuestion(viewModel.questionNumber)

        currentQuestion = viewModel.currentQuestion
        options = viewModel.options
    }

}