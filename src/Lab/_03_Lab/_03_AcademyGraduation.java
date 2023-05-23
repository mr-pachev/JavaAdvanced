package Lab._03_Lab;

import java.util.*;

public class _03_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> studentsMap = new TreeMap<>();

        for (int student = 1; student <= students; student++) {
            String name = scanner.nextLine();

            double[] grade = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentsMap.put(name, grade);
        }

        for (Map.Entry<String, double[]> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + isAvr(entry.getValue()));
        }

    }

    public static double isAvr (double[] grades){
        double sum = 0;

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }
}
