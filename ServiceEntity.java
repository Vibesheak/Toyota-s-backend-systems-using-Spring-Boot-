package com.ToyotaWeb.Toyota.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CustomerId", nullable = false)
    private int CustomerId;

    @Column(name = "Type", nullable = false)
    private String Type;

    @Column(name = "Cost", nullable = false)
    private double Cost;

    @Column(name = "Warranty", nullable = false)
    private double Warranty;

    // Other fields and getters/setters
}
