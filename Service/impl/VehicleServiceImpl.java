package com.ToyotaWeb.Toyota.Service.impl;
import com.ToyotaWeb.Toyota.Model.Vehicle;
import com.ToyotaWeb.Toyota.Repository.VehicleRepository;
import com.ToyotaWeb.Toyota.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
   public VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new RuntimeException("Vehicle not found");
        }
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, Long id) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setDate(vehicle.getDate());
        existingVehicle.setFuel_Type(vehicle.getFuel_Type());
        existingVehicle.setCapacity(vehicle.getCapacity());
        existingVehicle.setPrice(vehicle.getPrice());
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicleRepository.deleteById(id);
    }
}

