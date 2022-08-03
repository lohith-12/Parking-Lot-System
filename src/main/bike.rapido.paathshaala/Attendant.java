public class Attendant {

    Integer capacity ;

    Integer slots;

    ParkingSlotAllocationSystem [] Lots;

    public Attendant(Integer capacity, int slots) {
        this.capacity = capacity;
        Lots = new ParkingSlotAllocationSystem[capacity];
        this.slots=slots;
        init();
    }

    public int getAvailableLot(){

        for(int i=0;i<this.capacity;i++){
            if(this.Lots[i].isSpaceAvailable() == true)
                return i;
        }
        return -1;
    }

    public boolean park(){
        int index= this.getAvailableLot();
        if(index!=-1){
            Lots[index].allocateSpace();
            return true;
        }
        else{
          return false;
        }
    }
    public boolean unpark(){
        for(int i=0;i<this.capacity;i++){
            if(this.Lots[i].availableSpace < this.Lots[i].maxSpace)
            {
                Lots[i].deallocateSpace();
                return true;
            }
        }
        return false;

    }

    public void init()
    {
        for(int i=0;i<this.capacity;i++){
            this.Lots[i]=new ParkingSlotAllocationSystem(slots);
        }
    }



}
