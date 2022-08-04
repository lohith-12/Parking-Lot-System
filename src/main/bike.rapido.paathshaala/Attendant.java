import java.util.ArrayList;
import java.util.Arrays;

public class Attendant {

    Integer capacity ;

    Integer numberOfLots;

    ParkingLot[] Lots ;

    ParkingLotAllocationSystem parkingLotAllocationSystem;
    private NotificationManager notificationManager;
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeFull = new ArrayList<ParkingLotObserver>(Arrays.asList(new Owner(), new SecurityPersonal()));
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeNotFull = new ArrayList<ParkingLotObserver>(Arrays.asList(new Owner()));

    public Attendant(Integer capacity,int numberOfLots ) {
        this.capacity = capacity;
        this.numberOfLots=numberOfLots;
        Lots = new ParkingLot[numberOfLots];
        initializeParkingLot();
        parkingLotAllocationSystem = new ParkingLotAllocationSystem();
        notificationManager = new NotificationManager("Full", "NotFull");
        subscribeAllParkingLotObserver();
    }



    public ParkFunctionReturnType park(Car car){
        int lotId =-1;
        for(int index=0;index<numberOfLots;index++){
            if(parkingLotAllocationSystem.allocateSlotForCar(Lots[index],car)){
                 lotId=index;
                if(checkToNotifyWhetherLotIsFullOrNot(Lots[index])){
                    notifyLotObserversThatSlotIsFull(Lots[index].getId());
                }
                 return  new ParkFunctionReturnType(true,lotId);

            }
        }
        return new ParkFunctionReturnType(false,-1);
    }


public void subscribeAllParkingLotObserver(){
    notificationManager.subscribe("Full", parkingLotObserverListForEventTypeFull);
    notificationManager.subscribe("NotFull", parkingLotObserverListForEventTypeNotFull);
}

    public boolean unPark(Car car){
        for(int index=0;index<numberOfLots;index++){
            if(parkingLotAllocationSystem.deallocateSpace(Lots[index],car)){
                if(checkToNotifyWhetherLotIsFreeAgainOrNot(Lots[index])){
                    notifyLotObserversThatSlotIsFull(Lots[index].getId());
                    return true;
                }
                return  true;
            }
        }
        return false;

    }

    public void initializeParkingLot()
    {
        for(int i=0;i<this.numberOfLots;i++){
            Lots[i]=new ParkingLot(capacity,i);
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
