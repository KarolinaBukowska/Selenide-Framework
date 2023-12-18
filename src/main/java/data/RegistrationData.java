package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = RegistrationData.RegistrationDataBuilder.class)

public class RegistrationData {

    String firstName;
    String lastName;
    String emailAddress;
    String password;
    String confirmPassword;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder(withPrefix = "")
    public static final class RegistrationDataBuilder {
    }

}
