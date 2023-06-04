package _08_GenericScale;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> test = new Scale<>(3, 12);

        System.out.println(test.getHeavier());
    }
}
