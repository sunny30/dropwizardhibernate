package io.com.dropwizard.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateGuestRequest {


    private String firstName;


    private String lastName;


    private String email;

    @JsonCreator
    public CreateGuestRequest(@JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastname, @JsonProperty("email") String email) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
    }

    public CreateGuestRequest() {

    }

  //  @JsonGetter("first_name")
    public String getFirstName() {
        return firstName;
    }

    //@JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

  //  @JsonGetter("last_name")
    public String getLastName() {
        return lastName;
    }


 //   @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  //  @JsonGetter("email")
    public String getEmail() {
        return email;
    }

//    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

}
