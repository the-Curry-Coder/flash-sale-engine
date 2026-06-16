package com.thecurrycoder.flashsaleengine.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(length = 50)
    private Long phoneNumber;

    private String createdBy ;

    private LocalDateTime createdOn;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

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
