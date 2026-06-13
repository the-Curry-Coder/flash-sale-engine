package com.thecurrycoder.flashsaleengine.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity(name = "user")
@Data
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;

    @Column(unique = true,updatable = false)
    private String username;

    @Column(length = 100)
    private String firstName ;

    @Column(length = 100)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(length = 200)
    private String addressLine1;

    @Column(length = 200)
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String state ;

    @Column(length = 100)
     private String zip;

     private Boolean status = Boolean.TRUE;

     private String password;


     @ManyToMany
     @JoinTable(
             name = "user_role_relation",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id")
     )
     private List<Role> roles;


}
