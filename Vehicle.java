package com.ToyotaWeb.Toyota.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Model", nullable = false)
    private String Model;

    @Column(name = "Type", nullable = false)
    private String Type;

    @Column(name = "Date", nullable = false)
    private int Date;

    @Column(name = "Fuel_Type", nullable = false)
    private String Fuel_Type;

    @Column(name = "Capacity", nullable = false)
    private String Capacity;

    @Column(name = "Price", nullable = false)
    private double Price;


    // Other fields and getters/setters
}
