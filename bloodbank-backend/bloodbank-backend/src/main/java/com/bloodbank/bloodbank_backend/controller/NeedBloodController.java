package com.bloodbank.bloodbank_backend.controller;

import com.bloodbank.bloodbank_backend.entity.NeedBloodEntity;
import com.bloodbank.bloodbank_backend.service.NeedBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NeedBloodController {

    @Autowired
    private NeedBloodService needBloodService;

    @PostMapping("/need-blood")
    public NeedBloodEntity newNeedBlood(@RequestBody NeedBloodEntity newNeedBlood) {
        return needBloodService.saveNeedBlood(newNeedBlood);
    }

    @GetMapping("/need-blood")
    public List<NeedBloodEntity> getAllNeedBlood() {
        return needBloodService.findAll();
    }

    @DeleteMapping("/need-blood/{id}")
    public void deleteNeedBlood(@PathVariable Long id) {
        needBloodService.deleteNeedBloodById(id);
    }
}
