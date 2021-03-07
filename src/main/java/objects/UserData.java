package objects;

import lombok.Data;

@Data
public class UserData {
    String fullName;
    String phone_mask;

    public UserData(String fullName, String phone_mask) {
        this.fullName = fullName;
        this.phone_mask = phone_mask;
    }

}
