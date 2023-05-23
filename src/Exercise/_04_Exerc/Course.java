package Exercise._04_Exerc;

import java.io.Serializable;

public class Course implements Serializable {
    public Course(String name, int students) {
        this.name = name;
        this.students = students;
    }

    String name;
    int students;

}
