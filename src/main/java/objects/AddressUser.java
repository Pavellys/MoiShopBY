package objects;

import lombok.Data;

@Data
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

    public AddressUser(String shipCity, String shipZipCode, String shipRegion, String shipDistrict, String shipStreet, String shipHouse, String shipBuilding, String shipAppt, String shipEntrance, String shipFloor) {
        this.shipCity = shipCity;
        this.shipZipCode = shipZipCode;
        this.shipRegion = shipRegion;
        this.shipDistrict = shipDistrict;
        this.shipStreet = shipStreet;
        this.shipHouse = shipHouse;
        this.shipBuilding = shipBuilding;
        this.shipAppt = shipAppt;
        this.shipEntrance = shipEntrance;
        this.shipFloor = shipFloor;
    }
}
