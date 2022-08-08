public class Owner implements ParkingLotObserver{

    @Override
    public void notifyAccordingToEvent(String eventType,int lotId) {
        if(eventType == "Full"){
            System.out.println("Owner Alert : PARKING LOT "+ lotId+" IS FULL.SHOW FULL SIGN BOARD");
        } else if (eventType == "NotFull") {
            System.out.println("Hey, Parking Lot has space again !!Remove Full Sign Board");
        }
    }
}
