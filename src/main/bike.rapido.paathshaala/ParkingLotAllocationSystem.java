public class ParkingLotAllocationSystem {
    public boolean allocateSlotForCar(ParkingLot parkingLot, Car car){
        if(car.isParked()){
            return false;
        }
        if(parkingLot.checkForAvailabilityOfSlots()){
            parkingLot.addCar(car);
            car.setParkedStatusTrue();
            return true;
        }
        return false;
    }
    public boolean deallocateSpace(ParkingLot parkingLot, Car car){
        if(!car.isParked()){
            return false;
        }
        return parkingLot.removeCar(car);
    }
}