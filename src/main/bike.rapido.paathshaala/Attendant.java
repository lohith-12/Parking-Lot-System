public class Attendant {

    Integer capacity ;

    ParkingSlotAllocationSystem [] Lots;

    public Attendant(Integer capacity, ParkingSlotAllocationSystem[] lots) {
        this.capacity = capacity;
        Lots = lots;
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
            this.Lots[i]=new ParkingSlotAllocationSystem(capacity);
        }
    }



}
