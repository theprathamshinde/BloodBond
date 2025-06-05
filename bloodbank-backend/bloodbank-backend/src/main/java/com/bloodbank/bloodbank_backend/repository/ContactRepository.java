package com.bloodbank.bloodbank_backend.repository;

import com.bloodbank.bloodbank_backend.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
