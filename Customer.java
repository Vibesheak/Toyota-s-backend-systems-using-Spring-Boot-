package com.ToyotaWeb.Toyota.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "vehicle_id", nullable = false)
    private int vehicle_id;

    @Column(name = "purchase_date", nullable = false)
    private Date purchase_date;

    @Column(name = "purchase_location", nullable = false)
    private String purchase_location;

    @Column(name = "payment_method", nullable = false)
    private String payment_method;

    @Column(name = "address", nullable = false)
    private String Address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    // Other fields and getters/setters
}
