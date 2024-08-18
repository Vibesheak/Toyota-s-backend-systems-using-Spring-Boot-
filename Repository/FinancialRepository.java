package com.ToyotaWeb.Toyota.Repository;

import com.ToyotaWeb.Toyota.Model.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial, Long> {
}
