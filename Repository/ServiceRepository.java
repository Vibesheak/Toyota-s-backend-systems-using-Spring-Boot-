package com.ToyotaWeb.Toyota.Repository;

import com.ToyotaWeb.Toyota.Model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
