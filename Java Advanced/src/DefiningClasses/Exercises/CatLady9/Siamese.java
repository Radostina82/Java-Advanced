package DefiningClasses.Exercises.CatLady9;

public class Siamese{
    private String breeds;
    private String name;
    private double earSize;

    public Siamese(String breeds, String name, double earSize) {
        this.breeds = breeds;
        this.name = name;
        this.earSize = earSize;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.breeds, this.name, this.earSize);
    }
}
