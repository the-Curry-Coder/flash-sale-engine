package com.thecurrycoder.flashsaleengine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "address")
@Data
@ToString
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 100)
    private String addressLine1;

    @Column(length = 100)
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state ;

    @Column(length = 200)
    private String country;

    @Column(length = 50)
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

}
