import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager {
    Map<String, List<ParkingLotObserver>> parkingLotObservers = new HashMap<>();
    public NotificationManager(String... eventTypeList) {
        for(String eventType : eventTypeList)
        {
            this.parkingLotObservers.put(eventType, new ArrayList<>());
        }
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
}
