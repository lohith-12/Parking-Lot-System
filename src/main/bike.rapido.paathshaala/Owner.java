public class Owner implements ParkingLotObserver{
    public void showFullSignBoard() {
        System.out.println("Owner Alert : PARKING LOT IS FULL.SHOW FULL SIGN BOARD");
    }

    @Override
    public void notifyAccordingToEvent(String eventType) {
        if(eventType == "Full"){
            showFullSignBoard();
        } else if (eventType == "NotFull") {
            System.out.println("Hey, Parking Lot has space again !!Remove Full Sign Board");
        }
    }
}
