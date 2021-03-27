package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.Street;
import com.vzaichenko.map.entity.StreetEntity;
import com.vzaichenko.map.service.StreetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("street")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StreetController {
    private final StreetService streetService;

    @GetMapping("/showAll")
    public List<Street> showAll() {
        return streetService.findAll();
    }

    @GetMapping("/{id}")
    public Street showById(@PathVariable("id") Long id) {
        return streetService.findById(id);
    }

    @PostMapping("/create")
    public Street create(@RequestBody Street street) {
        return streetService.save(street);
    }

    @PostMapping("/edit/{id}")
    public Street edit(@RequestBody Street street) {
        return streetService.update(street);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        streetService.deleteById(id);
    }
}
