package Exercise._03_Exerc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03_LogsAggregator {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = Integer.parseInt(scanner.nextLine());
//
//        Map<String, TreeMap<String, Integer>> map = new TreeMap<>();
//
//        for (int i = 1; i <= n; i++) {
//            String[] inputData = scanner.nextLine().split(" ");
//
//            String name = inputData[1];
//            String ipAddress = inputData[0];
//            int onlineTime = Integer.parseInt(inputData[2]);
//
//            if (!map.containsKey(name)) {                                             //проверка дали името не е записано в мапа
//                TreeMap<String, Integer> ipAddressMap = new TreeMap<>();
//                ipAddressMap.put(ipAddress, onlineTime);
//                map.put(name, ipAddressMap);
//            } else {
//                TreeMap<String, Integer> ipAddressMap = map.get(name);              //взима вътрешния мап на дадения потребител
//                if (!ipAddressMap.containsKey(ipAddress)) {                          //ако адреса не съществува
//                    ipAddressMap.put(ipAddress, onlineTime);
//                } else {
//                    int currentOnlineTime = ipAddressMap.get(ipAddress);
//                    ipAddressMap.put(ipAddress, currentOnlineTime + onlineTime);    //добавя новото време към времето на текущия ipAddress
//                }
//                map.put(name, ipAddressMap);                                        //добавя се към основния мап
//            }
//        }
//
//        //принтиране на мап-а
//        for (String name : map.keySet()) {                                          //обхождане на основния мап по ключ
//            System.out.printf("%s: ", name);
//
//            Map<String, Integer> ipAddressMap = map.get(name);                      //взимане на вътрешния мап по конкретния ключ на основния мап
//
//            int count = ipAddressMap.size();                                        //брой стойности на вътрешния мап
//            for (String address : ipAddressMap.keySet()) {                          //обхождане на вътрешния мап по ключ
//                int sum = 0;
//
//                if (count == 1 && count != ipAddressMap.size()) {                   //ако вътрешния мап не е само с един ключ и конкретния е последния
//                    System.out.printf("%s]%n", address);
//
//                } else if (count == ipAddressMap.size() && count != 1){             //ако вътрешния мап не е само с един ключ и конкретния елемент е първия
//                    for (int num : ipAddressMap.values()) {                         //обхожда стойностите от вътрешния мап на конкретния ключ
//                        sum += num;                                                 //изчислява сбора на стойностите на вътрешния мап на конкретния ключ
//                    }
//                    System.out.printf("%d ", sum);
//                    System.out.printf("[%s, ", address);
//
//                }else if (count != ipAddressMap.size() && count > 1){               //ако стойността на вътрешния мап е в средата
//                    System.out.printf("%s, ", address);
//
//                }else {
//                    for (int num : ipAddressMap.values()) {                         //когато стойността на вътрешния мап е от един елемент
//                        sum += num;
//                    }
//                    System.out.printf("%d ", sum);
//                    System.out.printf("[%s]%n", address);
//                }
//                count--;
//            }
//        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, LinkedHashMap<String, Integer>> users = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String line = reader.readLine();

            String[] tokens = line.split(" ");

            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>()); //add the user if absent
            }

            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, duration); //add the ip and duration if absent
            } else {
                users.get(user).put(ip, users.get(user).get(ip) + duration); //increment the duration if we have the ip already
            }
        }

        users.entrySet()
                .stream()
                .sorted((u1, u2) -> u1.getKey().compareTo(u2.getKey())) //order the users alphabetically
                .forEach(u -> {
                    int totalDuration = u.getValue()
                            .values()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum(); //get sum all of ip addresses

                    String[] ips = u.getValue()
                            .keySet()
                            .stream()
                            .sorted()
                            .toArray(String[]::new); //get only ip addresses and sort them alphabetically

                    System.out.printf("%s: %d [%s]%n",
                            u.getKey(),
                            totalDuration,
                            String.join(", ", ips));
                });
    }
}
