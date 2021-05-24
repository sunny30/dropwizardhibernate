package io.com.dropwizard.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GuestResponse {

    @JsonProperty("guest_name")
    private String guestName ;

    @JsonProperty("contact_info")
    private String contactInfo ;

    @JsonProperty("id")
    private Long id ;


    GuestResponse(){

    }


    public GuestResponse(String firstName,String lastName,String email,Long id){
        this.guestName = String.format("%s %s",firstName,lastName) ;
        this.contactInfo = email ;
        this.id = id ;
    }



}
