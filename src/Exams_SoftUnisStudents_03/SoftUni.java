package Exams_SoftUnisStudents_03;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (capacity > data.size()) {
            if (this.data.contains(student)) {
                return "Student is already in the hall.";
            } else {
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }

        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student){
        if (this.data.contains(student)){
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName){
       for (Student current : data){
           if (current.getFirstName().equals(firstName) && current.getLastName().equals(lastName)){
               return current;
           }
       }
        return null;
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hall size: " + getCount() + System.lineSeparator());

        for (Student student : data){
            builder.append("Student: " + student.getFirstName() + " " + student.getLastName() + ", Best Course = " + student.getBestCourse());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
