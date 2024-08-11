package com.ToyotaWeb.Toyota.Repository;

import com.ToyotaWeb.Toyota.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
