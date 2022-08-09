import java.util.Optional;

public class Attendant {
    Integer capacity ;
    Integer numberOfLots;
    ParkingLot[] parkingLots;
    ParkingLotAllocationSystem parkingLotAllocationSystem;
    private NotificationManager notificationManager;
    private ParkingStrategy parkingStrategy;

    public Attendant(Integer capacity,int numberOfLots ) {
        this.capacity = capacity;
        this.numberOfLots=numberOfLots;
        parkingLots = new ParkingLot[numberOfLots];
        initializeParkingLot();
        parkingLotAllocationSystem = new ParkingLotAllocationSystem();
        notificationManager = new NotificationManager("Full", "NotFull");
    }

    public Optional<ParkingLot> park(Car car){
        ParkingLot parkingLot = parkingStrategy.getParkingLot(parkingLots);
        if (parkingLot!=null) {
            if (parkingLotAllocationSystem.allocateSlotForCar(parkingLot, car)) {
                if (checkToNotifyWhetherLotIsFullOrNot(parkingLot)) {
                    notifyLotObserversThatSlotIsFull(parkingLot.getId());
                }
                return Optional.of(parkingLot);

            }
        }git

        return Optional.empty();
    }

    public boolean unPark(Car car){
        for(int index=0;index<numberOfLots;index++){
            if(parkingLotAllocationSystem.deallocateSpace(parkingLots[index],car)){
                if(checkToNotifyWhetherLotIsFreeAgainOrNot(parkingLots[index])){
                    notifyLotObserversThatSlotHasSpaceAgain(parkingLots[index].getId());
                    return true;
                }
            }
        }
        return false;
    }
    public void initializeParkingLot()
    {
        for(int i=0;i<this.numberOfLots;i++){
            parkingLots[i]=new ParkingLot(capacity,i);
        }
    }
    public void notifyLotObserversThatSlotIsFull(int lotId){
        notificationManager.notify("Full",lotId);
    }

    private boolean checkToNotifyWhetherLotIsFullOrNot(ParkingLot parkingLot) {
        return parkingLot.getAllocatedSlots()==parkingLot.getTotalCapacity();
    }
    public void notifyLotObserversThatSlotHasSpaceAgain(int lotId){
        notificationManager.notify("NotFull",lotId);

    }
    private boolean checkToNotifyWhetherLotIsFreeAgainOrNot(ParkingLot parkingLot) {
        return parkingLot.getAllocatedSlots()==parkingLot.getTotalCapacity()-1;
    }

    public void setStrategy(ParkingStrategy parkingStrategy)
    {
        this.parkingStrategy= parkingStrategy;
    }
}
