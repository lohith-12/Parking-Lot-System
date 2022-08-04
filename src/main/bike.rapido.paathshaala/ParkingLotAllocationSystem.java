public class ParkingLotAllocationSystem {
    private final Integer TOTAL_SPACE = 2;
    public Integer availableSpace;
    ParkingLot parkingLot;
  //  private NotificationManager notificationManager;
    Car car;
    public int maxSpace;


    public ParkingLotAllocationSystem() {
        //maxSpace=availableSpace;
        //availableSpace = availableSpace;
        //notificationManager = new NotificationManager("Full", "NotFull");

//        this.parkingLot=parkingLot;
//        this.car=car;
    }

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
        parkingLot.removeCar(car);
        car.setParkedStatusFalse();

        return true;
    }

//    private boolean checkToNotifyWhetherLotIsFullOrNot(ParkingLot parkingLot) {
//        return parkingLot.getAllocatedSlots()==parkingLot.getTotalCapacity();
//    }


//    public void notifyLotObserversThatSlotIsFull(int lotId){
//        notificationManager.notify("Full",lotId);
//    }





}