package DefiningClasses.Exercises.PokemonTrainer6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
        LinkedHashMap<String, Trainer> trainerList = readTrainerList(scanner);


        String input = scanner.nextLine();

        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
                if (entry.getValue().getPokemons().size() > 0) {
                    if (entry.getValue().isContains(input)) {
                        entry.getValue().setCountBadges();
                    }else {
                        for (Pokemon pokemon : entry.getValue().getPokemons()) {
                            int health = pokemon.getHealth();
                            if (health-10>0){
                                pokemon.setHealth(health-10);
                            }else {
                                entry.getValue().getPokemons().remove(pokemon);
                                break;
                            }
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
        trainerList.entrySet().stream().
                sorted((e1, e2) -> Integer.compare(e2.getValue().getCountBadges(), e1.getValue().getCountBadges())).
                forEach(trainer -> System.out.println(trainer.getValue()));
    }

    public static LinkedHashMap<String, Trainer> readTrainerList(Scanner scanner) {
        LinkedHashMap<String, Trainer> trainerList = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);
            trainerList.putIfAbsent(trainerName, new Trainer());
            trainerList.get(trainerName).setName(trainerName);
            trainerList.get(trainerName).getPokemons().add(pokemon);
            input = scanner.nextLine();
        }
        return trainerList;
    }
}
