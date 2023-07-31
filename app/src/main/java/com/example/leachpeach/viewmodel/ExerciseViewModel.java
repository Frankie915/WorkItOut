package com.example.leachpeach.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.leachpeach.database.WorkoutDatabase;
import com.example.leachpeach.model.Exercise;
import com.example.leachpeach.repository.WorkoutRepository;

import java.util.List;

public class ExerciseViewModel extends AndroidViewModel {
    private WorkoutRepository repository;
    private LiveData<List<Exercise>> allExercises;
    private LiveData<List<Exercise>> exerciseSet;

    public ExerciseViewModel(@NonNull Application application) {
        super(application);
        WorkoutDatabase db = WorkoutDatabase.getInstance(application);
        repository = new WorkoutRepository(db);
        allExercises = repository.getAllExercises();
        exerciseSet = repository.getExerciseSet();
    }

    public LiveData<List<Exercise>> getAllExercises() {
        return allExercises;
    }
    public LiveData<List<Exercise>> getExerciseSet() { return exerciseSet; }
    public LiveData<Exercise> getExercise(int id) {
        return repository.getExercise(id);
    }

}
