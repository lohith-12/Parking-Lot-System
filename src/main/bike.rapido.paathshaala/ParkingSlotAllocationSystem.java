import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingSlotAllocationSystem {
    private final Integer TOTAL_SPACE = 2;
    private Integer availableSpace;
    private NotificationManager notificationManager;
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeFull = new ArrayList<ParkingLotObserver>(Arrays.asList(new Owner(), new SecurityPersonal()));
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeNotFull = new ArrayList<ParkingLotObserver>(Arrays.asList(new Owner()));


    public ParkingSlotAllocationSystem(Integer availableSpace) {
        this.availableSpace = availableSpace;
        this.notificationManager = new NotificationManager("Full", "NotFull");
        subscribeAllParkingLotObserver();
    }
    public void subscribeAllParkingLotObserver(){
        notificationManager.subscribe("Full", parkingLotObserverListForEventTypeFull);
        notificationManager.subscribe("NotFull", parkingLotObserverListForEventTypeNotFull);
    }
    public String allocateSpace(){
        String message;
        if(availableSpace >0){
            availableSpace -= 1;
            message = Messages.SLOT_IS_ALLOCATED_SUCCESSFULLY;
        }
        else {
            notifyLotObserversThatSlotIsFull();
            message = Messages.ALL_SLOTS_ARE_OCCUPIED;
        }
        return message;
    }
    public void notifyLotObserversThatSlotIsFull(){
        notificationManager.notify("Full");
    }
    public void notifyLotObserversThatSlotHasSpaceAgain(){
        notificationManager.notify("NotFull");

    }

    public String deallocateSpace(){
        String message;
        if(availableSpace == TOTAL_SPACE){
            message = Messages.NO_SLOT_ALLOCATED_YET;
        }
        else{
            availableSpace++;
            if(availableSpace == 1)
            {
                notifyLotObserversThatSlotHasSpaceAgain();
            }
            message = Messages.SLOT_REMOVED_SUCCESSFULLY;
        }

        return message;
    }


}