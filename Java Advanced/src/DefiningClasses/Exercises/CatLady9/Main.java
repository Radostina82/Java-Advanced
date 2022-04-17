package DefiningClasses.Exercises.CatLady9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, Cat> listCat = new HashMap<>();

        while (!input.equals("End")){
            String breeds = input.split("\\s+")[0];

            if (breeds.equals("Siamese")){
                String name = input.split("\\s+")[1];
                double earSize = Double.parseDouble(input.split("\\s+")[2]);
            Siamese siamese = new Siamese(breeds, name, earSize);
            listCat.putIfAbsent(name, new Cat());
            listCat.get(name).getCatSiamese().add(siamese);
            }else if (breeds.equals("Cymric")){
                String name = input.split("\\s+")[1];
                double furLength = Double.parseDouble(input.split("\\s+")[2]);
                Cymric cymric = new Cymric(breeds, name, furLength);
                listCat.putIfAbsent(name, new Cat());
                listCat.get(name).getCatCymric().add(cymric);
            }else if (breeds.equals("StreetExtraordinaire")){
                String name = input.split("\\s+")[1];
                double decibelsOfMeows = Double.parseDouble(input.split("\\s+")[2]);
                StreetExtraordinaire street = new StreetExtraordinaire(breeds, name, decibelsOfMeows);
                listCat.putIfAbsent(name, new Cat());
                listCat.get(name).getCatStreet().add(street);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        boolean isCat = false;
        for (Map.Entry<String, Cat> catEntry : listCat.entrySet()) {
            Cat cat = catEntry.getValue();
          List<Siamese> siamese = cat.getCatSiamese();
          List<Cymric> cymrics = cat.getCatCymric();
          List<StreetExtraordinaire> street = cat.getCatStreet();
            for (Siamese siamese1 : siamese) {
                if (siamese1.getName().equals(input)){
                    System.out.println(siamese1);
                    break;
                }
            }
            for (Cymric cymric : cymrics) {
                if (cymric.getName().equals(input)){
                    System.out.println(cymric);
                    break;
                }
            }
            for (StreetExtraordinaire streetExtraordinaire : street) {
                if (streetExtraordinaire.getName().equals(input)){
                    System.out.println(streetExtraordinaire);
                    break;
                }
            }
        }
    }
}
