public class CarAllocationSystem {
    private Integer availableSpace = 2;

    private final Integer TOTAL_SPACE = 2;
    Owner owner;
    SecurityPersonal securityPersonal;

    public CarAllocationSystem() {
        this.owner = new Owner();
        this.securityPersonal = new SecurityPersonal();
    }

    public void setAvailableSpace(Integer availableSpace) {
        this.availableSpace = availableSpace;
    }

    public  Integer getAvailableSpace() {
        return availableSpace;
    }

    public boolean checkAvailability(){
        return (availableSpace>0);
    }

    public String allocateSpace(){
        String message;
        if(checkAvailability()){
            availableSpace -= 1;
            message = "Your car parked successfully.";
            return message;
        }
        notifyPerson();
        message = "Sorry! All slots are occupied.";
        return message;
    }

    public String deallocateSpace(){
        String message;
        if(availableSpace == TOTAL_SPACE){
            message = "Sorry, no car is parked yet.";
            return message;
        }
        availableSpace++;
        message = "Your car removed successfully.";
        return message;
    }

    public void notifyPerson(){
        owner.showFullSignBoard();
        securityPersonal.redirectMySecurityStaff();
    }

}