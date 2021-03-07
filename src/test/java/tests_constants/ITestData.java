package tests_constants;

import objects.AddressUser;
import objects.UserData;

public interface ITestData {
    UserData userData = new UserData("Pavel", "3333856769");
    AddressUser addressUser = new AddressUser("Брест", "210110", "Брестская",
            "Брестский", "Папанина", "22", "1", "22", "2", "1");
}
