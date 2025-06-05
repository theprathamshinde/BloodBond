package com.bloodbank.bloodbank_backend.repository;

import com.bloodbank.bloodbank_backend.entity.DonateBloodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateBloodRepository extends JpaRepository<DonateBloodEntity, Long> {
}
