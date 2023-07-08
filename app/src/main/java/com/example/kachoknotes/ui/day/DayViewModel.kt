package com.example.kachoknotes.ui.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kachoknotes.clean.DayRepository
import com.example.kachoknotes.clean.DayRepositoryImpl
import com.example.kachoknotes.entity.Day
import java.util.*

class DayViewModel(
    private val daysRepository: DayRepository = DayRepositoryImpl.instance.value
) : ViewModel() {

    private val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    val getLiveData: LiveData<Day>
        get() = daysRepository.getDay(date)

    fun addTrain(){
        daysRepository.addTraining(date)
    }
}