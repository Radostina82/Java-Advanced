package DefiningClasses.Exercises.FamilyTree8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        List<String> idParent = new ArrayList<>();
        List<String> idChild = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("-")) {
                idParent.add(input.split(" - ")[0]);
                idChild.add(input.split(" - ")[1]);
            } else {
                String name = input.split("\\s+")[0] + " " + input.split("\\s+")[1];
                String birthDay = input.split("\\s+")[2];
                Person person = new Person();
                person.setPersonName(name);
                person.setPersonBirthDay(birthDay);
                people.add(person);
            }

            input = scanner.nextLine();
        }
        FamilyTree familyTree = new FamilyTree();
        for (Person person : people) {
            if (person.getPersonName().equals(data) || person.getPersonBirthDay().equals(data)) {
                familyTree.setPerson(person);
                break;
            }
        }

        for (Person person : people) {
            for (int i = 0; i < idParent.size(); i++) {
                Person child = new Person();
                if (person.getPersonName().equals(idParent.get(i)) || person.getPersonBirthDay().equals(idParent.get(i))) {
                    String search = idChild.get(i);
                    if (search.contains("/")) {
                        child = people.stream().filter(p -> p.getPersonBirthDay().equals(search)).findFirst().orElse(null);
                    } else {
                        child = people.stream().filter(p -> p.getPersonName().equals(search)).findFirst().orElse(null);
                    }
                    if (familyTree.getPerson().getPersonName().equals(idParent.get(i)) || familyTree.getPerson().getPersonBirthDay().equals(idParent.get(i))) {
                        if (child != null) {
                            familyTree.getChildren().add(child);
                        }
                    }
                }
            }
            for (int i = 0; i < idChild.size(); i++) {
                Person parent = new Person();
                if (person.getPersonName().equals(idChild.get(i)) || person.getPersonBirthDay().equals(idChild.get(i))) {
                    String search = idParent.get(i);
                    if (search.contains("/")) {
                        parent = people.stream().filter(p -> p.getPersonBirthDay().equals(search)).findFirst().orElse(null);
                    } else {
                        parent = people.stream().filter(p -> p.getPersonName().equals(search)).findFirst().orElse(null);
                    }
                    if (familyTree.getPerson().getPersonName().equals(idChild.get(i)) || familyTree.getPerson().getPersonBirthDay().equals(idChild.get(i))) {
                        if (parent != null) {
                            familyTree.getParent().add(parent);
                        }
                    }
                }
            }
        }
        System.out.println(familyTree);
    }


}
