package Lab._03_Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingMovement = new LinkedHashSet<>();

        while(!input.equals("END")) {
            String[] inputData = input.split(", ");

            String movement = inputData[0];
            String carNumber = inputData[1];

            if(movement.equals("IN")){
                parkingMovement.add(carNumber); //SET-добавя сама елементи, които не съдържа
            }else if (movement.equals("OUT")){
                parkingMovement.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if(!parkingMovement.isEmpty()) {
            for (String s : parkingMovement) {
                System.out.println(s);
            }
        }else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
