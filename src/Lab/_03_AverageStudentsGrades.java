package Lab;

import java.util.*;

public class _03_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsMap = new TreeMap<>();

        //пълнене на map-a
        for (int student = 1; student <= n; student++) {
            String[] inputData = scanner.nextLine().split(" ");

            String currentStudent = inputData[0];
            double grade = Double.parseDouble(inputData[1]);

            if (!studentsMap.containsKey(currentStudent)) {
                List<Double> list = new ArrayList<>();
                list.add(grade);

                studentsMap.put(currentStudent, list);
            } else {
                List<Double> currentList = studentsMap.get(currentStudent);
                currentList.add(grade);
                studentsMap.put(currentStudent, currentList);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double avg = 0;

            for (int i = 0; i < entry.getValue().size(); i++) {
                avg += entry.getValue().get(i);
                System.out.printf("%.2f ", entry.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)%n", avg / entry.getValue().size());
        }
    }
}
