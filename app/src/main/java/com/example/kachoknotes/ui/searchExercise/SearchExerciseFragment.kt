package com.example.kachoknotes.ui.searchExercise

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kachoknotes.databinding.FragmentSearchExerciseBinding

class SearchExerciseFragment : Fragment() {

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchExerciseViewModel::class.java)
        // TODO: Use the ViewModel
    }
    companion object {
        fun newInstance() = SearchExerciseFragment()
    }
}