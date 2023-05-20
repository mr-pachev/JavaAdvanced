package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> itMap = new TreeMap<>();
        Map<String, Integer> ipCountMap = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0];
            ip = ip.split("\\=")[1];

            String user = input.split("\\s+")[2];
            user = user.split("\\=")[1];

            if (!itMap.containsKey(user)) {
                ipCountMap = new LinkedHashMap<>();
                ipCountMap.put(ip, 1);
                itMap.put(user, ipCountMap);
            } else {
                ipCountMap = itMap.get(user); //мап със зъписаните адреси на конкретния потребител

                if (!ipCountMap.containsKey(ip)) { //ако конкретние ip-адрес не е записан в мапа
                    ipCountMap.put(ip, 1);
                } else {
                    ipCountMap.put(ip, ipCountMap.get(ip) + 1);
                }
                itMap.put(user, ipCountMap);

            }

            input = scanner.nextLine();
        }

        int counter = 0;                                                        //определя броя от броя ключовете на вътрешния мап
        for (Map.Entry<String, Map<String, Integer>> entry : itMap.entrySet()) {
            System.out.println(entry.getKey() + ":");                           //принтира ключа на основния мап

            for (Map.Entry<String, Integer> entryValue : entry.getValue().entrySet()) {
                System.out.printf("%s => ", entryValue.getKey());               //принтиране на ключа на вътрешния мап
                counter++;

                if (counter < entry.getValue().size()) {                        //проверява дали ключа на вътрешния мап не е последен, зада изпечати стойността му със запетайка
                    System.out.printf("%d, %n", entryValue.getValue());
                } else {
                    System.out.printf("%d.%n", entryValue.getValue());
                }

            }

        }
    }
}
