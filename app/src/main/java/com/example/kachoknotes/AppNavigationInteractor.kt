package com.example.kachoknotes

import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kachoknotes.clean.DayRepository
import com.example.kachoknotes.clean.DayRepositoryImpl

class AppNavigationInteractor private constructor() {

    data class AppBarData(
        val title: String,
        @DrawableRes val icon: Int
    )

    enum class Screen {
        Day,
        SearchExercise
    }

    private val _currentScreen = MutableLiveData(Screen.Day)
    private val _appBarData = MutableLiveData<AppBarData>()

    val currentScreen: LiveData<Screen>
        get() = _currentScreen

    val appBarData: LiveData<AppBarData>
        get() = _appBarData

    fun navigateTo(screen: Screen) {
        _currentScreen.postValue(screen)
    }

    fun setAppBarData(appBarData: AppBarData){
        _appBarData.postValue(appBarData)
    }

    companion object {
        val instance = lazy {
            AppNavigationInteractor()
        }
    }
}