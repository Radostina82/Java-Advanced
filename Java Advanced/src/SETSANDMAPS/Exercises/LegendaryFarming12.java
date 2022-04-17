package SETSANDMAPS.Exercises;

import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> materials = new TreeMap<>();
        TreeMap<String, Integer>junk = new TreeMap<>();
        String win = "";
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        while (win.equals("")){

            String []input = scanner.nextLine().split("\\s+");
            int count =0;
            int countMaterials = 0;
            for (String element : input) {
                count++;
                if (count%2!=0){
                countMaterials = Integer.parseInt(element);
                }else {
                    if (element.toLowerCase().equals("shards")){
                        materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) + countMaterials);
                        if (materials.get(element.toLowerCase()) >=250){
                            win = "Shadowmourne";
                            materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) - 250);
                            break;
                        }

                    }else if (element.toLowerCase().equals("fragments")){
                        materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) + countMaterials);
                        if (materials.get(element.toLowerCase()) >=250){
                            win = "Valanyr";
                            materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) - 250);
                            break;
                        }
                    }else if (element.toLowerCase().equals("motes")){
                        materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) + countMaterials);
                        if (materials.get(element.toLowerCase()) >=250){
                            win = "Dragonwrath";
                            materials.put(element.toLowerCase(), materials.get(element.toLowerCase()) - 250);
                            break;
                        }
                    }else {
                        junk.putIfAbsent(element.toLowerCase(),0);
                        junk.put(element.toLowerCase(), junk.get(element.toLowerCase()) + countMaterials);
                    }
                }
            }
        }

        System.out.printf("%s obtained!%n", win);
        materials.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
