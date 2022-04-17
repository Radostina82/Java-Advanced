package DefiningClasses.Exercises.CarSalesman5;

public class Engine {
   //model, power, displacement and efficiency
    private String model;
    private String power;
    //optional
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, String power, String displacement, String efficiency) {
      this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
