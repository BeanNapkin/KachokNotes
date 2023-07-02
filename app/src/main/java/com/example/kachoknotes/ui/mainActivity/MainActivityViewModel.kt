package com.example.kachoknotes.ui.mainActivity

import androidx.lifecycle.ViewModel
import com.example.kachoknotes.clean.DayRepository
import com.example.kachoknotes.clean.DayRepositoryImpl
import java.util.*

class MainActivityViewModel(
    private val daysRepository: DayRepository = DayRepositoryImpl.instance.value
) : ViewModel()  {

    private val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    fun addTraining(){
        daysRepository.addTraining(date)
    }
}