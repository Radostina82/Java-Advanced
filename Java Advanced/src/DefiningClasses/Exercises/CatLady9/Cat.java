package DefiningClasses.Exercises.CatLady9;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private List<Siamese> catSiamese;
    private List<Cymric> catCymric;
    private List<StreetExtraordinaire> catStreet;

    public Cat() {
        this.catSiamese = new ArrayList<>();
        this.catCymric = new ArrayList<>();
        this.catStreet = new ArrayList<>();
    }

    public List<Siamese> getCatSiamese() {
        return catSiamese;
    }

    public List<Cymric> getCatCymric() {
        return catCymric;
    }

    public List<StreetExtraordinaire> getCatStreet() {
        return catStreet;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if (catSiamese.size()>0){
            for (Siamese siamese : catSiamese) {
                builder.append(siamese).append(System.lineSeparator());
            }
        }
        if (catCymric.size()>0){
            for (Cymric cymric : catCymric) {
                builder.append(cymric).append(System.lineSeparator());
            }
        }
        if (catStreet.size()>0){
            for (StreetExtraordinaire streetExtraordinaire : catStreet) {
                builder.append(streetExtraordinaire).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }

}
