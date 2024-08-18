package com.ToyotaWeb.Toyota.Service;

import com.ToyotaWeb.Toyota.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle updateVehicle(Vehicle vehicle, Long id);
    void deleteVehicle(Long id);
}
