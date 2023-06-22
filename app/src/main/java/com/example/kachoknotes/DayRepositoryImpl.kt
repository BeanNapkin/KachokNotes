package com.example.kachoknotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kachoknotes.entity.Day
import com.example.kachoknotes.entity.Workout
import kotlin.collections.HashMap

class DayRepositoryImpl private constructor() : DayRepository {

    private val days = HashMap<Int, MutableLiveData<Day>>()

    override fun addDay(day: Day) {
        addOrGet(day.date).postValue(day)
    }

    override fun getDay(date: Int): LiveData<Day> {
        return addOrGet(date)
    }

    override fun addTraining(date: Int) {
        val liveData = addOrGet(date)
        val day = liveData.value ?: error("Day can not be null")
        day.workouts.add(Workout(day.workouts.size + 1, mutableListOf()))
        liveData.postValue(day)
    }

    private fun addOrGet(date: Int) : MutableLiveData<Day>{
        if (days.containsKey(date).not()){
            days[date] = MutableLiveData(Day(date, mutableListOf()))
        }
        return days.getValue(date)
    }

    companion object {
        val instance = lazy {
            DayRepositoryImpl()
        }
    }
}