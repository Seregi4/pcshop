package com.levanov.pcshop.controller;


import com.levanov.pcshop.entity.Laptop;
import com.levanov.pcshop.repository.LaptopRepository;
import com.levanov.pcshop.service.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/laptops")
@Tag(name = "Laptop - controller", description = "Взаимодействие с ноутбуками(добавить, найти, изменить, вывести все")
public class LaptopController {
    @Autowired
    private final LaptopRepository laptopRepository;
    @Autowired
    private final LaptopService laptopService;


    public LaptopController(LaptopRepository laptopRepository, LaptopService laptopService) {
        this.laptopRepository = laptopRepository;
        this.laptopService = laptopService;
    }

    @PostMapping()
    @Operation(
            summary = "Добавление ноутбука",
            description = "Позволяет добавить  ноутбук"
    )
    public Laptop save(@RequestBody Laptop laptop) {

        return laptopService.save(laptop);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление ноутбука",
            description = "Позволяет обновить ноутбук"
    )
    public ResponseEntity<?> partialUpdateLaptop(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody Laptop laptop
    ) throws URISyntaxException {

        if (laptop.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }
        if (!Objects.equals(id, laptop.getId())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);

        }

        if (!laptopRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        }

        Optional<Laptop> result = laptopService.update(laptop);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "получение ноутбука по id",
            description = "Позволяет получить ноутбук по id"
    )

    public Optional<Laptop> getLaptopById(@PathVariable Long id) {

        Optional<Laptop> laptop = laptopService.findById(id);
        if (!laptopRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return laptop;
    }


    @GetMapping()
    @Operation(
            summary = "Получение списка ноутбуков",
            description = "Позволяет получить список всех ноутбуков"
    )
    public List<Laptop> getAllLaptop() {

        return laptopService.findAll();
    }
}
