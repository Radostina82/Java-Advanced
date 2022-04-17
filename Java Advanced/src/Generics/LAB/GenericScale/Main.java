package Generics.LAB.GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "z");
        System.out.println(scale.getHeavier());
    }
}
