package DefiningClasses.Exercises.SpeedRacing3;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled.
    private String model;
    private double fuelAmount;
    private double costFor1Km;
    private int distance;

    public Car(String model, double fuelAmount, double costFor1Km){
        this.setModel(model);
        this.setFuelAmount(fuelAmount);
        this.setCostFor1Km(costFor1Km);
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getCostFor1Km() {
        return costFor1Km;
    }

    public int getDistance() {
        return distance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setCostFor1Km(double costFor1Km) {
        this.costFor1Km = costFor1Km;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean canMove(int km){
        return km * this.costFor1Km <= this.fuelAmount;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d", getModel(), getFuelAmount(), getDistance());
    }
}
