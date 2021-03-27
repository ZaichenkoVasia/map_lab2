package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.Country;
import com.vzaichenko.map.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/showAll")
    public List<Country> showAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country showById(@PathVariable("id") Long id) {
        return countryService.findById(id);
    }

    @PostMapping("/create")
    public Country create(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PostMapping("/edit/{id}")
    public Country edit(@RequestBody Country country) {
        return countryService.update(country);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        countryService.deleteById(id);
    }
}
