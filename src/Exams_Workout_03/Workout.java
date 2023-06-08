package Exams_Workout_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > this.exercises.size()) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        boolean isRemoved = false;
        for (Exercise exercise : new ArrayList<Exercise>(exercises)) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : new ArrayList<Exercise>(exercises)) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {

        if (!exercises.isEmpty()) {
            this.exercises = this.exercises.stream()
                    .sorted(Comparator.comparing(Exercise::getBurnedCalories))
                    .collect(Collectors.toList());
            return exercises.get(exercises.size() - 1);
        }
        return null;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Workout type: %s", type));

        for (Exercise current : exercises) {
            builder.append(System.lineSeparator());
            builder.append(current);
        }
        return builder.toString();
    }
}
