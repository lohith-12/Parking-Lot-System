public class ParkingSlotAllocationSystem {
    private final Integer TOTAL_SPACE = 2;
    private Integer availableSpace = 2;

    Owner owner;
    SecurityPersonal securityPersonal;

    public ParkingSlotAllocationSystem(Owner owner,SecurityPersonal securityPersonal) {
        this.owner = owner;
        this.securityPersonal = securityPersonal;
    }

    public String allocateSpace(){
        String message;
        if(availableSpace>0){
            availableSpace -= 1;
            message = Messages.SLOT_IS_ALLOCATED_SUCCESSFULLY;
        }
        else {
            notifyThatAllSlotsFilled();
            message = Messages.ALL_SLOTS_ARE_OCCUPIED;
        }
        return message;
    }

    public String deallocateSpace(){
        String message;
        if(availableSpace == TOTAL_SPACE){
            message = Messages.NO_SLOT_ALLOCATED_YET;
        }
        else{
            availableSpace++;
            message = Messages.SLOT_REMOVED_SUCCESSFULLY;
        }

        return message;
    }

    public void notifyThatAllSlotsFilled(){
        if(owner!=null && securityPersonal !=null) {
            owner.showFullSignBoard();
            securityPersonal.redirectMySecurityStaff();
        }
    }

}