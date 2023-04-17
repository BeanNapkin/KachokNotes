package com.example.kachoknotes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kachoknotes.databinding.FragmentExerciseListBinding

class ExerciseListFragment : Fragment() {

    private var _binding: FragmentExerciseListBinding? = null
    val binding: FragmentExerciseListBinding
        get() {
            return _binding!!
        }

    private lateinit var viewModel: ExerciseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
        _binding = FragmentExerciseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExerciseListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = ExerciseListFragment()
    }

}