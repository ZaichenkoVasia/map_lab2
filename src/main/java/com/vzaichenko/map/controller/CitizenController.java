package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.service.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citizen")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CitizenController {
    private final CitizenService citizenService;

    @GetMapping("/showAll")
    public List<Citizen> showAll() {
        return citizenService.findAll();
    }

    @GetMapping("/{id}")
    public Citizen showById(@PathVariable("id") Long id) {
        return citizenService.findById(id);
    }

    @PostMapping("/create")
    public Citizen create(@RequestBody Citizen citizen) {
        return citizenService.save(citizen);
    }

    @PostMapping("/edit/{id}")
    public Citizen edit(@RequestBody Citizen citizen) {
        return citizenService.update(citizen);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        citizenService.deleteById(id);
    }
}
