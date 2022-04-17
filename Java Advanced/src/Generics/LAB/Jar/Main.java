package Generics.LAB.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("12");
        jar.add("15");
        jar.add("1");

        System.out.println(jar.remove());
        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
