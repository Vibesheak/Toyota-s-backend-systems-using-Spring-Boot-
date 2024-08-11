package com.ToyotaWeb.Toyota.Service;

import com.ToyotaWeb.Toyota.Model.ServiceEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface ServiceService {
    ServiceEntity saveService(ServiceEntity service);
    List<ServiceEntity> getAllServices();
    ServiceEntity getServiceById(Long id);
    ServiceEntity updateService(ServiceEntity service, Long id);
    void deleteService(Long id);
}
