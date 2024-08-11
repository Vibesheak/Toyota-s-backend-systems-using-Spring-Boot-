package com.ToyotaWeb.Toyota.Service.impl;
import com.ToyotaWeb.Toyota.Model.Financial;
import com.ToyotaWeb.Toyota.Repository.FinancialRepository;
import com.ToyotaWeb.Toyota.Service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialRepository financialRepository;

    @Override
    public Financial saveFinancial(Financial financial) {
        return financialRepository.save(financial);
    }

    @Override
    public List<Financial> getAllFinancials() {
        return financialRepository.findAll();
    }

    @Override
    public Financial getFinancialById(long id) {
        Optional<Financial> financial = financialRepository.findById(id);
        if (financial.isPresent()) {
            return financial.get();
        } else {
            throw new RuntimeException("Financial record not found for id: " + id);
        }
    }

    @Override
    public Financial updateFinancial(Financial financial, long id) {
        Financial existingFinancial = financialRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Financial record not found for id: " + id)
        );
        existingFinancial.setCustomerId(financial.getCustomerId());
        existingFinancial.setVehicleId(financial.getVehicleId());
        existingFinancial.setFinanceAmount(financial.getFinanceAmount());
        existingFinancial.setInterestRate(financial.getInterestRate());
        existingFinancial.setDuration(financial.getDuration());
        existingFinancial.setMonthlyPayment(financial.getMonthlyPayment());
        financialRepository.save(existingFinancial);
        return existingFinancial;
    }

    @Override
    public void deleteFinancial(long id) {
        financialRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Financial record not found for id: " + id)
        );
        financialRepository.deleteById(id);
    }
}
