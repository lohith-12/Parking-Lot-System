import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
public class NotificationManager {
    Map<String, List<ParkingLotObserver>> parkingLotObservers = new HashMap<>();
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeFull = new ArrayList<>(Arrays.asList(new Owner(), new SecurityPersonal()));
    ArrayList<ParkingLotObserver> parkingLotObserverListForEventTypeNotFull = new ArrayList<>(Arrays.asList(new Owner()));

    public NotificationManager(String... eventTypeList) {
        for(String eventType : eventTypeList)
        {
            this.parkingLotObservers.put(eventType, new ArrayList<>());
        }
        subscribeAllParkingLotObserver();
    }
    public void subscribe(String eventType, ArrayList<ParkingLotObserver> parkingLotObserverList){
        List<ParkingLotObserver> lotObserverList = parkingLotObservers.get(eventType);
        for(ParkingLotObserver parkingLotObserver:parkingLotObserverList){
            lotObserverList.add(parkingLotObserver);
        }
    }

    public void notify(String eventType,int lotId){
        List<ParkingLotObserver> lotObserverList = parkingLotObservers.get(eventType);
        for(ParkingLotObserver lotObserver:lotObserverList){
            lotObserver.notifyAccordingToEvent(eventType,lotId);
        }
    }
    public void subscribeAllParkingLotObserver(){
        subscribe("Full", parkingLotObserverListForEventTypeFull);
        subscribe("NotFull", parkingLotObserverListForEventTypeNotFull);
    }

}
