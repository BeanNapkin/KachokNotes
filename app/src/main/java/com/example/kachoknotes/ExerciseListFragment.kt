package com.example.kachoknotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kachoknotes.databinding.FragmentExerciseListBinding
import com.example.kachoknotes.databinding.WorkoutBinding
import com.example.kachoknotes.entity.Repetition
import com.example.kachoknotes.entity.Workout

class ExerciseListFragment : Fragment() {

    private var _binding: FragmentExerciseListBinding? = null
    val binding: FragmentExerciseListBinding
        get() {
            return _binding!!
        }

    private lateinit var viewModel: ExerciseListViewModel

    val adapter = RecyclerAdapter<Workout>(
        emptyList(),
        R.layout.workout
    ) {workout, _ ->
        WorkoutBinding.bind(this).apply {
            nameTextView.text = workout.name
            repetitionTextView.text = workout.repetitions.first().quantity.toString() + " x " + workout.repetitions.first().weight.toString() + " кг"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExerciseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repetition = Repetition(1, 10, 15.00)
        val repetitions = listOf(repetition)

        val workout = Workout(1, "Приседания со штангой", "", repetitions)
        val workouts = listOf(workout)

        binding.recyclerView.adapter = adapter
        adapter.itemList = workouts
    }

    companion object {
        fun newInstance() = ExerciseListFragment()
    }
}