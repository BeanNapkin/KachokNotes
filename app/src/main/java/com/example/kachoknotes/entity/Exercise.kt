package com.example.kachoknotes.entity

data class Exercise(
    val id: Int,
    val name: String,
    var image: String,
    var repetitions: List<Repetition>
)
