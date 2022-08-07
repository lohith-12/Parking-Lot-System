import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int totalCapacity ;
    private  int allocatedSlots=0;

    public int getId() {
        return id;
    }

    private final int id;
    private List<Car> parkedCarList = new ArrayList<>();
    public ParkingLot(int capacity,int i) {
        this.totalCapacity= capacity;
        this.id = i;
    }
    public boolean checkForAvailabilityOfSlots(){
        return allocatedSlots<totalCapacity;
    }
    public boolean addCar(Car car){
        parkedCarList.add(car);
        allocatedSlots=allocatedSlots+1;
        return true;
    }
    public boolean removeCar(Car car){
        if(!parkedCarList.contains(car)){
            return false;
        }
        parkedCarList.remove(car);
        car.setParkedStatusFalse();
        allocatedSlots =allocatedSlots-1;
        return true;
    }
    public int getTotalCapacity(){
        return totalCapacity;
    }

    public int getAllocatedSlots() {
        return allocatedSlots;
    }
}
