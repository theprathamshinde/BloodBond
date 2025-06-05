package com.bloodbank.bloodbank_backend.repository;

import com.bloodbank.bloodbank_backend.entity.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HostRepository extends JpaRepository<HostEntity, Long> {

}

