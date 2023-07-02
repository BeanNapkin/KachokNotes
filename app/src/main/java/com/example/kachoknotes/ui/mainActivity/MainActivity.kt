package com.example.kachoknotes.ui.mainActivity

import android.os.Bundle
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
    private val appNavigationInteractor: AppNavigationInteractor = AppNavigationInteractor.instance.value

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        appNavigationInteractor.currentScreen.observe(this){
            when(it){
                AppNavigationInteractor.Screen.Day ->
                    replaceFragment(DayFragment())
                AppNavigationInteractor.Screen.SearchExercise ->
                    replaceFragment(SearchExerciseFragment())
            }
        }
    }
    override fun onStart() {
        super.onStart()

        binding.appBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add_train -> viewModel.addTraining()
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)

        if (supportFragmentManager.fragments.isNotEmpty())
        {
            transaction.addToBackStack(null);
        }

        transaction.commit()
    }
}