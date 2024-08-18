package com.ToyotaWeb.Toyota.Repository;
import com.ToyotaWeb.Toyota.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
