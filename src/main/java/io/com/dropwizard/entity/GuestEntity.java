package io.com.dropwizard.entity;


import lombok.Getter;

import javax.persistence.*;



@Getter
@Entity
@Table(name = "guests")
@NamedQueries({
        @NamedQuery(name = "io.com.dropwizard.entity.findById",
            query =  "select g from GuestEntity g "+"where g.id = :id"),
        @NamedQuery(name = "io.com.dropwizard.entity.findAll",
                query =  "select g from GuestEntity g")
})
public class GuestEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;


    public GuestEntity(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email ;
    }

    public GuestEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email ;
    }

    public GuestEntity(){

    }

}
