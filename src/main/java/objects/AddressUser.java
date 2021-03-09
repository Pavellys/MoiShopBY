package objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressUser {
    String shipCity;
    String shipZipCode;
    String shipRegion;
    String shipDistrict;
    String shipStreet;
    String shipHouse;
    String shipBuilding;
    String shipAppt;
    String shipEntrance;
    String shipFloor;
}
