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
            ip = ip.split("=")[1];

            String user = input.split("\\s+")[2];
            user = user.split("=")[1];

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


        for (String username : itMap.keySet()) {
            //data.keySet() -> списък с всички usernames
            System.out.println(username + ": ");

            //ip-тата на username
            Map<String, Integer> currentIps = itMap.get(username); //map с ip-ата на дадения username

            int countIps = currentIps.size(); //брой на ip-тата = брой на записите в мап
            //currentIps: ip (key) -> count(value)
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    //Последното ip за отпечатване
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    //не ми е последното ip
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }
        }

    }
}
