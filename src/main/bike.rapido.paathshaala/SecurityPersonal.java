public class SecurityPersonal implements ParkingLotObserver{


    @Override
    public void notifyAccordingToEvent(String eventType,int lotId) {
        if(eventType == "Full"){
            System.out.println("Secutity Personal Alert : Parking Lot " + lotId + " is full");
        }
    }
}
