package tests_data;

import objects.AddressUser;
import objects.UserData;


public class TestData {
    UserData userData = new UserData("Pavel", "3333856769");

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public AddressUser getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(AddressUser addressUser) {
        this.addressUser = addressUser;
    }

    AddressUser addressUser = new AddressUser("Брест", "210110", "Брестская",
            "Брестский", "Папанина", "22", "1", "22", "2", "1");
}
