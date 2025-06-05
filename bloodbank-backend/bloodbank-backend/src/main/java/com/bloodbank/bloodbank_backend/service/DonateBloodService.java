package com.bloodbank.bloodbank_backend.service;

import com.bloodbank.bloodbank_backend.entity.DonateBloodEntity;
import com.bloodbank.bloodbank_backend.repository.DonateBloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonateBloodService {

    @Autowired
    private DonateBloodRepository donateBloodRepository;

    public DonateBloodEntity saveDonateBlood(DonateBloodEntity donateBlood) {
        return donateBloodRepository.save(donateBlood);
    }

    public List<DonateBloodEntity> findAll() {
        return donateBloodRepository.findAll();
    }

    public void deleteDonateBlood(Long id) {
        donateBloodRepository.deleteById(id);
    }
}
