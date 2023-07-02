package com.example.kachoknotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kachoknotes.clean.DayRepository
import com.example.kachoknotes.clean.DayRepositoryImpl

class AppNavigationInteractor private constructor() {

    enum class Screen{
        Day,
        SearchExercise
    }

    private val _currentScreen = MutableLiveData(Screen.Day)

    val currentScreen: LiveData<Screen>
        get() = _currentScreen

    fun navigateTo(screen: Screen){
        _currentScreen.postValue(screen)
    }

    companion object {
        val instance = lazy {
            AppNavigationInteractor()
        }
    }
}