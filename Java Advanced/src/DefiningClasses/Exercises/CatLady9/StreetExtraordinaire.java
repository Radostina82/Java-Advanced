package DefiningClasses.Exercises.CatLady9;

public class StreetExtraordinaire {
    private String breeds;
    private String name;
    private double decibelsOfMeows;

    public StreetExtraordinaire(String breeds,String name, double decibelsOfMeows) {
        this.breeds = breeds;
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.breeds, this.name, this.decibelsOfMeows);
    }
}
