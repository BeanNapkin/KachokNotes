package com.example.kachoknotes

import androidx.lifecycle.LiveData
import com.example.kachoknotes.entity.Day

interface DayRepository {
    fun addDay(day: Day)
    fun getDay(date: Int): LiveData<Day>
    fun addTraining(date: Int)
}