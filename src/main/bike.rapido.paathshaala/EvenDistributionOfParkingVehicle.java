public class EvenDistributionOfParkingVehicle implements ParkingStrategy{


    @Override
    public ParkingLot getParkingLot(ParkingLot[] parkingLots) {
        ParkingLot minimumAllocatedParkingLot = null;
        int minimumNumberOfSlots =  Integer.MAX_VALUE;
        for (ParkingLot parkingLot: parkingLots) {
            if (parkingLot.getAllocatedSlots() < minimumNumberOfSlots) {
                minimumNumberOfSlots = parkingLot.getAllocatedSlots();
                minimumAllocatedParkingLot = parkingLot;
            }
        }
        return minimumAllocatedParkingLot;
    }

}
