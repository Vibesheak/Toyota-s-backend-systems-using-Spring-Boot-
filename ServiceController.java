package com.ToyotaWeb.Toyota.Controller;

import com.ToyotaWeb.Toyota.Model.ServiceEntity;
import com.ToyotaWeb.Toyota.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceEntity> saveService(@RequestBody ServiceEntity service) {
        return new ResponseEntity<>(serviceService.saveService(service), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(serviceService.getServiceById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable("id") Long id, @RequestBody ServiceEntity service) {
        return new ResponseEntity<>(serviceService.updateService(service, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>("Service deleted successfully", HttpStatus.OK);
    }
}
