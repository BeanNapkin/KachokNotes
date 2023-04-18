package com.example.kachoknotes.entity

data class Workout(
    val id: Int,
    val name: String,
    var image: String,
    var repetitions: List<Repetition>
)
