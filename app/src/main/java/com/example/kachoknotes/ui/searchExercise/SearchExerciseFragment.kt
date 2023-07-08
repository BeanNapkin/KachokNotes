package com.example.kachoknotes.ui.searchExercise

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.kachoknotes.AppNavigationInteractor
import com.example.kachoknotes.R
import com.example.kachoknotes.databinding.FragmentSearchExerciseBinding

class SearchExerciseFragment : Fragment() {

    private val appNavigationInteractor: AppNavigationInteractor = AppNavigationInteractor.instance.value

    private var _binding: FragmentSearchExerciseBinding? = null
    val binding: FragmentSearchExerciseBinding
        get() {
            return _binding!!
        }

    private lateinit var viewModel: SearchExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        appNavigationInteractor.setAppBarData(
            AppNavigationInteractor.AppBarData(
            "Найти упражнение", -1))


    }

    companion object {
        fun newInstance() = SearchExerciseFragment()
    }
}