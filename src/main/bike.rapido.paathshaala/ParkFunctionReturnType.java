public class ParkFunctionReturnType {
    private boolean isParked=false;
    private int lotNumber =-1;

    public  ParkFunctionReturnType(boolean isParked,int lotNumber){
        this.isParked=isParked;
        this.lotNumber = lotNumber;
    }

    public boolean getIsParked() {
        return isParked;
    }


    public int getLotNumber() {
        return lotNumber;
    }


}
