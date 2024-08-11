package com.ToyotaWeb.Toyota.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rating_ranking")
public class RatingRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vehicle_id", nullable = false)
    private long vehicleId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "ranking", nullable = false)
    private int ranking;
}
