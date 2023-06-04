package _08_Lab_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> names = new Jar<>();

        names.add("Ivan");
        names.add("Cvetan");
        names.add("Petkan");
        names.add("Dragan");
        names.remove();

        System.out.println();
    }
}
