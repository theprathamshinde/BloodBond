package com.bloodbank.bloodbank_backend.controller;

import com.bloodbank.bloodbank_backend.entity.HostEntity;
import com.bloodbank.bloodbank_backend.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @PostMapping("/host")
    public HostEntity newHost(@RequestBody HostEntity newHost) {
        return hostService.saveHost(newHost);
    }

    @GetMapping("/host")
    public List<HostEntity> getAllHost() {
        return hostService.findAll();
    }

    @DeleteMapping("/host/delete/{id}")
    public void deleteHost(@PathVariable Long id) {
        hostService.deleteHost(id);
    }
}
