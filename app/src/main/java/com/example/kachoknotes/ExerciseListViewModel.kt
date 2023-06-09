package com.example.kachoknotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kachoknotes.entity.Day
import java.util.*

class ExerciseListViewModel(
    private val daysRepository: DayRepository = DayRepositoryImpl.instance.value
) : ViewModel() {

    private val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

    val getLiveData: LiveData<Day>
        get() = daysRepository.getDay(date)
}