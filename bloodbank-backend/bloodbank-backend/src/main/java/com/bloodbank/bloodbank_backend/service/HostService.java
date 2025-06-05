package com.bloodbank.bloodbank_backend.service;

import com.bloodbank.bloodbank_backend.entity.HostEntity;
import com.bloodbank.bloodbank_backend.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public HostEntity saveHost(HostEntity host) {
        return hostRepository.save(host);
    }

    public List<HostEntity> findAll() {
        return hostRepository.findAll();
    }

    public void deleteHost(Long id) {
        hostRepository.deleteById(id);
    }
}
