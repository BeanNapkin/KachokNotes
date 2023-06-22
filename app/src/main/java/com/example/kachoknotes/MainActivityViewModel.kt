package com.example.kachoknotes

import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel(
    private val daysRepository: DayRepository = DayRepositoryImpl.instance.value
) : ViewModel()  {

    private val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    fun addTraining(){
        daysRepository.addTraining(date)
    }
}