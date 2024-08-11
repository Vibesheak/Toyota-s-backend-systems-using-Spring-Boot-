package com.ToyotaWeb.Toyota.Service.impl;

import com.ToyotaWeb.Toyota.Model.ServiceEntity;
import com.ToyotaWeb.Toyota.Repository.ServiceRepository;
import com.ToyotaWeb.Toyota.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceEntity saveService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceEntity getServiceById(Long id) {
        Optional<ServiceEntity> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            return service.get();
        } else {
            throw new RuntimeException("Service not found");
        }
    }

    @Override
    public ServiceEntity updateService(ServiceEntity service, Long id) {
        ServiceEntity existingService = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        existingService.setCustomerId(service.getCustomerId());
        existingService.setType(service.getType());
        existingService.setCost(service.getCost());
        existingService.setWarranty(service.getWarranty());
        return serviceRepository.save(existingService);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        serviceRepository.deleteById(id);
    }
}
