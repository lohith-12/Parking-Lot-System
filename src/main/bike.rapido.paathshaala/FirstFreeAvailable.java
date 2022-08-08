public class FirstFreeAvailable implements ParkingStrategy {


    @Override
    public ParkingLot getParkingLot(ParkingLot[] parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAllocatedSlots() < parkingLot.getTotalCapacity()) {
                return parkingLot;
            }
        }
        return null;
    }
}
