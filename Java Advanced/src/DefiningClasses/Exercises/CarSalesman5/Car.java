package DefiningClasses.Exercises.CarSalesman5;

public class Car {
    //model, engine, weight and color.
    private String model;
    private Engine engine;
    //optional
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        //<CarModel>:
        //<EngineModel>:
        //Power: <EnginePower>
        //Displacement: <EngineDisplacement>
        //Efficiency: <EngineEfficiency>
        //Weight: <CarWeight>
        //Color: <CarColor>
        StringBuilder bilder = new StringBuilder();
        bilder.append(this.model).append(":");
        bilder.append(System.lineSeparator());
        bilder.append(engine.getModel()).append(":");
        bilder.append(System.lineSeparator());
        bilder.append("Power: ").append(engine.getPower());
        bilder.append(System.lineSeparator());
        bilder.append("Displacement: ").append(engine.getDisplacement());
        bilder.append(System.lineSeparator());
        bilder.append("Efficiency: ").append(engine.getEfficiency());
        bilder.append(System.lineSeparator());
        bilder.append("Weight: ").append(getWeight());
        bilder.append(System.lineSeparator());
        bilder.append("Color: ").append(getColor());
        return bilder.toString();
    }
}
