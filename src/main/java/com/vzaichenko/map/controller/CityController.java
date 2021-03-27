package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.City;
import com.vzaichenko.map.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {
    private final CityService cityService;

    @GetMapping("/showAll")
    public List<City> showAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City showById(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return cityService.save(city);
    }

    @PostMapping("/edit/{id}")
    public City edit(@RequestBody City city) {
        return cityService.update(city);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        cityService.deleteById(id);
    }
}
