package com.example.androidquiz.quizFragment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

data class Question(
    val title: String,
    val options: List<String>,
    val correctAnswer: String
)

class QuizViewModel : ViewModel() {
    //Initiliasing the viewmodel
    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    val questions = mutableListOf(
        Question("When was India liberated?",
            listOf("1947", "2022", "1950", "1847"), "1947"),
        Question("Entomology is the science that studies",
            listOf("Behaviour of human beings", "Insects", "The origin and history of technical and scientific terms", "The formation of rocks"),
            "Insects"),
        Question("The world smallest country is",
            listOf("Canada", "Sri Lanka", "Maldives", "Vatican City"), "Vatican City"),
        Question("Which company developed Android?",
            listOf("Google", "Microsoft", "Tesla", "PayPal"), "Google"),
        Question("What element does 'O' represent on the periodic table?",
            listOf("Oxygen", "Carbon", "Magnesium", "Ozone"), "Oxygen"),
        Question("What's the name of the river that runs through Egypt?",
            listOf("Nile", "Amazon", "Ganga", "Yamuna"), "Nile")
    )

    var questionNumber : Int = 0
    lateinit var currentQuestion : Question
    lateinit var options : List<String>

    fun getQuestions(){
        questionNumber = 0
        questions.shuffle()
    }

    fun getQuestion(index : Int){
        currentQuestion = questions[index]
        options = currentQuestion.options.shuffled()
    }

    fun incrementQuestion(){
        questionNumber++
    }

}