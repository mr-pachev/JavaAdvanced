package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> partyNote = new TreeSet<>();

        //запълване на списъка с гости
        while(!input.equals("PARTY")){
            String guest = input;

            partyNote.add(guest);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        //проверка на присъстващите гости
        while(!input.equals("END")){
            partyNote.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(partyNote.size());
        for (String s : partyNote) {
            System.out.println(s);
        }
    }
}
