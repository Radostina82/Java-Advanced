package DefiningClasses.Exercises.CatLady9;

public class Cymric {
    private String breeds;
    private String name;
    private double furLength;

    public Cymric(String breeds, String name, double furLength) {
        this.breeds = breeds;
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.breeds, this.name, this.furLength);
    }
}
