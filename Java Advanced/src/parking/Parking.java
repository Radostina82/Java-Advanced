package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        Car car = data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().orElse(null);
        if (car != null) {
            data.remove(car);
            return true;
        }
        return false;
    }

    public Car getLatestCar() {
        if (!data.isEmpty()) {
            Car car = null;
            int year = Integer.MIN_VALUE;
            for (Car datum : data) {
                if (datum.getYear() > year) {
                    year = datum.getYear();
                    car=datum;
                }
            }
            return car;
        }
        return null;
    }

    public  Car getCar(String manufacturer, String model){
        return data.stream().filter(c-> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        //o	"The cars are parked in {parking type}:
        //{Car1}
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are parked in %s:", this.type)).append(System.lineSeparator());
        for (Car datum : data) {
            builder.append(datum).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
