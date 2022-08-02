public class SecurityPersonal implements ParkingLotObserver{

    public void redirectMySecurityStaff() {
        System.out.println("SecurityPersonal Alert : REDIRECTING MY SECURITY STAFF");
    }

    @Override
    public void notifyAccordingToEvent(String eventType) {
        if(eventType == "Full"){
            redirectMySecurityStaff();
        }
    }
}
