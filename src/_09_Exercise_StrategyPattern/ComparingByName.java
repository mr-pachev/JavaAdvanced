package _09_Exercise_StrategyPattern;

import java.util.Comparator;

public class ComparingByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());

        if (result == 0){ //ако имената са с еднавква дължина
            char one = Character.toLowerCase(o1.getName().charAt(0));
            char two = Character.toLowerCase(o2.getName().charAt(0));

            result = Integer.compare(one, two);   //подредбата е по първата буква от името (0, -1 или 1)

            return result;
        }
        return result;
    }
}
