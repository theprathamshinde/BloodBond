package com.bloodbank.bloodbank_backend.repository;

import com.bloodbank.bloodbank_backend.entity.NeedBloodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeedBloodRepository extends JpaRepository<NeedBloodEntity, Long> {
}
