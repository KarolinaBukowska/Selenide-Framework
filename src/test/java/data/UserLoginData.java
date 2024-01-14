package data;

import lombok.Builder;
import lombok.Value;

@Value

public class UserLoginData {

    String emailAddress;
    String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginData(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public UserLoginData() {
        this.emailAddress = null;
        this.password = null;
    }
}
