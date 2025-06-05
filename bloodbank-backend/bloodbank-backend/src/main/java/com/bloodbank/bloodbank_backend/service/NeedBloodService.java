
package com.bloodbank.bloodbank_backend.service;

import com.bloodbank.bloodbank_backend.entity.NeedBloodEntity;
import com.bloodbank.bloodbank_backend.repository.NeedBloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeedBloodService {

    @Autowired
    private NeedBloodRepository needBloodRepository;

    public NeedBloodEntity saveNeedBlood(NeedBloodEntity needBlood) {
        return needBloodRepository.save(needBlood);
    }

    public List<NeedBloodEntity> findAll() {
        return needBloodRepository.findAll();
    }

    public void deleteNeedBloodById(Long id) {
        needBloodRepository.deleteById(id);
    }
}
