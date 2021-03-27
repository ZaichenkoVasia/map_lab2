package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.domain.Flat;
import com.vzaichenko.map.domain.Inhabitant;
import com.vzaichenko.map.service.InhabitantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inhabitant")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InhabitantController {
    private final InhabitantService inhabitantService;

    @GetMapping("/showAll")
    public List<Inhabitant> showAll() {
        return inhabitantService.findAll();
    }

    @GetMapping("/{id}")
    public Inhabitant showById(@PathVariable("id") Long id) {
        return inhabitantService.findById(id);
    }

    @PostMapping("/create")
    public Inhabitant create(@RequestBody Inhabitant inhabitant) {
        return inhabitantService.save(inhabitant);
    }

    @PostMapping("/edit/{id}")
    public Inhabitant edit(@RequestBody Inhabitant inhabitant) {
        return inhabitantService.update(inhabitant);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        inhabitantService.deleteById(id);
    }

    @GetMapping("/findFlatsBySurnameOfCitizen")
    public List<Flat> findFlatsBySurnameOfCitizen(@RequestParam("surname") String surname) {
        return inhabitantService.findFlatsBySurnameOfCitizen(surname);
    }

    @GetMapping("/findCitizensByNumberOfFlat")
    public List<Citizen> findCitizensByNumberOfFlat(@RequestParam("number") Integer number) {
        return inhabitantService.findCitizensByNumberOfFlat(number);
    }
}
