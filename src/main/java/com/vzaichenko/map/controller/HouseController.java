package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.House;
import com.vzaichenko.map.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HouseController {
    private final HouseService houseService;

    @GetMapping("/showAll")
    public List<House> showAll() {
        return houseService.findAll();
    }

    @GetMapping("/{id}")
    public House showById(@PathVariable("id") Long id) {
        return houseService.findById(id);
    }

    @PostMapping("/create")
    public House create(@RequestBody House house) {
        return houseService.save(house);
    }

    @PostMapping("/edit/{id}")
    public House edit(@RequestBody House house) {
        return houseService.update(house);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        houseService.deleteById(id);
    }
}
