package DefiningClasses.Exercises.PokemonTrainer6;



public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getElement() {
        return element;
    }
    public boolean isContainsElement(String element){

            if (this.element.equals(element)){
                return true;
            }

        return false;
    }
}
