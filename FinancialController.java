package com.ToyotaWeb.Toyota.Controller;

import com.ToyotaWeb.Toyota.Model.Financial;
import com.ToyotaWeb.Toyota.Service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial")
@CrossOrigin(origins = "*")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    @PostMapping
    public ResponseEntity<Financial> saveFinancial(@RequestBody Financial financial) {
        return new ResponseEntity<>(financialService.saveFinancial(financial), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Financial> getAllFinancials() {
        return financialService.getAllFinancials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Financial> getFinancialById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(financialService.getFinancialById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Financial> updateFinancial(@PathVariable("id") Long id, @RequestBody Financial financial) {
        return new ResponseEntity<>(financialService.updateFinancial(financial, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFinancial(@PathVariable("id") Long id) {
        financialService.deleteFinancial(id);
        return new ResponseEntity<>("Financial record deleted successfully", HttpStatus.OK);
    }
}
