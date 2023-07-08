package com.example.kachoknotes.ui.day

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kachoknotes.AppNavigationInteractor
import com.example.kachoknotes.R
import com.example.kachoknotes.databinding.ExerciseBinding
import com.example.kachoknotes.databinding.FragmentDayBinding
import com.example.kachoknotes.databinding.WorkoutBinding
import com.example.kachoknotes.entity.Exercise
import com.example.kachoknotes.entity.Workout
import com.example.kachoknotes.ui.RecyclerAdapter

class DayFragment : Fragment() {

    private val appNavigationInteractor: AppNavigationInteractor = AppNavigationInteractor.instance.value

    private var _binding: FragmentDayBinding? = null
    val binding: FragmentDayBinding
        get() {
            return _binding!!
        }

    private val viewModel: DayViewModel by lazy {
        ViewModelProvider(this).get(DayViewModel::class.java)
    }

    val adapterWorkout = RecyclerAdapter<Workout>(
        emptyList(),
        R.layout.workout
    ) {workout, _ ->
        WorkoutBinding.bind(this).apply {
            headerTextView.text = "Тренировка " + workout.id.toString()
            adapterExercise.itemList = workout.exercises
            recyclerView.adapter = adapterExercise
            addExerciseButton.setOnClickListener {
                appNavigationInteractor.navigateTo(AppNavigationInteractor.Screen.SearchExercise)

            }
        }
    }

    val adapterExercise = RecyclerAdapter<Exercise>(
        emptyList(),
        R.layout.exercise
    ){exercise, _ ->
        ExerciseBinding.bind(this).apply {
            nameTextView.text = exercise.name.toString()
            repetitionTextView.text = exercise.repetitions.first().quantity.toString() + " x " + exercise.repetitions.first().weight.toString() + " кг"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val repetition = Repetition(1, 10, 15.00)
//        val exercise = Exercise(1, "Приседания со штангой", "", listOf(repetition))
//        val exercises = listOf(exercise)
//        val workout = Workout(1, exercises)
//        val workouts = listOf(workout)
//        val day = Day(1, workouts)

        binding.recyclerView.adapter = adapterWorkout

        viewModel.getLiveData.observe(viewLifecycleOwner){
                adapterWorkout.itemList = it.workouts
                adapterWorkout.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_train -> {
                viewModel.addTrain()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        appNavigationInteractor.setAppBarData(AppNavigationInteractor.AppBarData(
            "Сегодня", R.drawable.calendar))
    }
}