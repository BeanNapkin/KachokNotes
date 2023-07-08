package com.example.kachoknotes.ui.mainActivity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kachoknotes.AppNavigationInteractor
import com.example.kachoknotes.ui.day.DayFragment
import com.example.kachoknotes.R
import com.example.kachoknotes.databinding.ActivityMainBinding
import com.example.kachoknotes.entity.Day
import com.example.kachoknotes.ui.searchExercise.SearchExerciseFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val appNavigationInteractor: AppNavigationInteractor =
        AppNavigationInteractor.instance.value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.appBar)

        appNavigationInteractor.currentScreen.observe(this) {
            when (it) {
                AppNavigationInteractor.Screen.Day -> {
                    replaceFragment(DayFragment())
                }

                AppNavigationInteractor.Screen.SearchExercise ->
                    replaceFragment(SearchExerciseFragment())

            }
        }

        appNavigationInteractor.appBarData.observe(this) {
            binding.appBar.setTitle(it.title)
            if (it.icon == -1){
                binding.appBar.setNavigationIcon(null)
            } else {
                binding.appBar.setNavigationIcon(it.icon)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)

        if (supportFragmentManager.fragments.isNotEmpty()) {
            transaction.addToBackStack(null);
        }

        transaction.commit()
    }
}