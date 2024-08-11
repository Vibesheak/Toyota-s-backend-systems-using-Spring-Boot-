package com.ToyotaWeb.Toyota.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "financial")
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "vehicle_id", nullable = false)
    private long vehicleId;

    @Column(name = "finance_amount", nullable = false)
    private double financeAmount;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @Column(name = "MonthlyPayment", nullable = false)
    private double MonthlyPayment;

    @Column(name = "duration", nullable = false)
    private int duration;
}
