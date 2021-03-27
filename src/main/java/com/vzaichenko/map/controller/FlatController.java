package com.vzaichenko.map.controller;

import com.vzaichenko.map.domain.Flat;
import com.vzaichenko.map.service.FlatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flat")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FlatController {
    private final FlatService flatService;

    @GetMapping("/showAll")
    public List<Flat> showAll() {
        return flatService.findAll();
    }

    @GetMapping("/{id}")
    public Flat showById(@PathVariable("id") Long id) {
        return flatService.findById(id);
    }

    @PostMapping("/create")
    public Flat create(@RequestBody Flat flat) {
        return flatService.save(flat);
    }

    @PostMapping("/edit/{id}")
    public Flat edit(@RequestBody Flat flat) {
        return flatService.update(flat);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        flatService.deleteById(id);
    }
}
