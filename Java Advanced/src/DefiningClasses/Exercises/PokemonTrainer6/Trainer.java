package DefiningClasses.Exercises.PokemonTrainer6;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int countBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
    }

    public Trainer() {
        this.pokemons = new ArrayList<>();
        this.countBadges=0;
    }
    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getCountBadges() {
        return countBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public boolean isContains(String element){
        for (Pokemon pokemon : pokemons) {
           if( pokemon.isContainsElement(element)){
               return true;
           }
        }
        return false;
    }
    public void setCountBadges() {
        this.countBadges = countBadges+1;
    }
    @Override
    public String toString(){
        //<TrainerName> <Badges> <NumberOfPokemon
        return this.name + " " + this.countBadges + " " + this.pokemons.size();
    }

}
