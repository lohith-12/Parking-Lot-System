public class ParkFunctionReturnType {
    private boolean isParked=false;
    private int lotnumber=-1;

    public  ParkFunctionReturnType(boolean isParked,int lotnumber){
        this.isParked=isParked;
        this.lotnumber=lotnumber;
    }

    public boolean getIsParked() {
        return isParked;
    }


    public int getLotnumber() {
        return lotnumber;
    }
}
