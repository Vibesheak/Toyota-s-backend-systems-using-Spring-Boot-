package com.ToyotaWeb.Toyota.Service;

import com.ToyotaWeb.Toyota.Model.Financial;

import java.util.List;

public interface FinancialService {
    Financial saveFinancial(Financial financial);
    List<Financial> getAllFinancials();
    Financial getFinancialById(long id);
    Financial updateFinancial(Financial financial, long id);
    void deleteFinancial(long id);
}
