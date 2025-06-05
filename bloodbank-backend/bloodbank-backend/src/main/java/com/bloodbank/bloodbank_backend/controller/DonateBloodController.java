package com.bloodbank.bloodbank_backend.controller;

import com.bloodbank.bloodbank_backend.entity.DonateBloodEntity;
import com.bloodbank.bloodbank_backend.service.DonateBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonateBloodController {

    @Autowired
    private DonateBloodService donateBloodService;

    @PostMapping("/donate-blood")
    public DonateBloodEntity newDonateBlood(@RequestBody DonateBloodEntity newDonateBlood) {
        return donateBloodService.saveDonateBlood(newDonateBlood);
    }

    @GetMapping("/donate-blood")
    public List<DonateBloodEntity> getAllDonateBlood() {
        return donateBloodService.findAll();
    }

    @DeleteMapping("/donate-blood/delete/{id}")
    public void deleteDonateBlood(@PathVariable Long id) {
        donateBloodService.deleteDonateBlood(id);
    }
}
