import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attendant {

    Integer capacity = 2;

    ParkingSlotAllocationSystem [] Lots= new ParkingSlotAllocationSystem[2];




    public int getAvailableLot(){

        for(int i=0;i<2;i++){
            if(this.Lots[i].isSpaceAvailable() == true)
                return i;
        }
        return -1;
    }

    public boolean Park(){
        int index= this.getAvailableLot();
        if(index!=-1){
            Lots[index].allocateSpace();
            return true;
        }
        else{
          return false;
        }
    }
    public boolean Unpark(){
        for(int i=0;i<2;i++){
            if(this.Lots[i].availableSpace < this.Lots[i].maxSpace)
            {
                Lots[i].deallocateSpace();
                return true;
            }
        }
        return false;

    }

    public void Init()
    {
        for(int i=0;i<2;i++){
            this.Lots[i]=new ParkingSlotAllocationSystem(capacity);
        }
    }

     public  void main(String[] args) {
        Attendant attendant= new Attendant();





    }

  //  Lots[0]= false // we will mark it false when it will become full



}
