import java.util.ArrayList;
import java.util.Arrays;

public class Attendant {

    Integer capacity ;

    Integer numberOfLots;

    ParkingLot[] ParkingLots;

    ParkingLotAllocationSystem parkingLotAllocationSystem;
    private NotificationManager notificationManager;
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeFull = new ArrayList<>(Arrays.asList(new Owner(), new SecurityPersonal()));
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeNotFull = new ArrayList<>(Arrays.asList(new Owner()));

    public Attendant(Integer capacity,int numberOfLots ) {
        this.capacity = capacity;
        this.numberOfLots=numberOfLots;
        ParkingLots = new ParkingLot[numberOfLots];
        initializeParkingLot();
        parkingLotAllocationSystem = new ParkingLotAllocationSystem();
        notificationManager = new NotificationManager("Full", "NotFull");
        subscribeAllParkingLotObserver();
    }



    public ParkFunctionReturnType park(Car car){
        int lotId;
        int parkingLotNumber = getParkingLotNumber();
        if(parkingLotAllocationSystem.allocateSlotForCar(ParkingLots[parkingLotNumber],car)){
            lotId=parkingLotNumber;
            if(checkToNotifyWhetherLotIsFullOrNot(ParkingLots[parkingLotNumber])){
                notifyLotObserversThatSlotIsFull(ParkingLots[parkingLotNumber].getId());
            }
            return  new ParkFunctionReturnType(true,lotId);

        }
        return new ParkFunctionReturnType(false,-1);
    }

    private int getParkingLotNumber() {
        int minimumAllocatedParkingLot = -1;
        int minimumNumberOfSlots =capacity+1;
        for(int index=0;index<numberOfLots;index++){
            if(ParkingLots[index].getAllocatedSlots()<minimumNumberOfSlots){
                minimumNumberOfSlots = ParkingLots[index].getAllocatedSlots();
                minimumAllocatedParkingLot = index;
            }
        }
        return minimumAllocatedParkingLot;
    }


    public void subscribeAllParkingLotObserver(){
        notificationManager.subscribe("Full", parkingLotObserverListForEventTypeFull);
        notificationManager.subscribe("NotFull", parkingLotObserverListForEventTypeNotFull);
    }

    public boolean unPark(Car car){
        for(int index=0;index<numberOfLots;index++){
            if(parkingLotAllocationSystem.deallocateSpace(ParkingLots[index],car)){
                if(checkToNotifyWhetherLotIsFreeAgainOrNot(ParkingLots[index])){
                    notifyLotObserversThatSlotHasSpaceAgain(ParkingLots[index].getId());
                    return true;
                }
            }
        }
        return false;
    }

    public void initializeParkingLot()
    {
        for(int i=0;i<this.numberOfLots;i++){
            ParkingLots[i]=new ParkingLot(capacity,i);
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

}
