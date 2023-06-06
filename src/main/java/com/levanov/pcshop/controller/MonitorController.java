package com.levanov.pcshop.controller;


import com.levanov.pcshop.entity.Monitor;
import com.levanov.pcshop.repository.MonitorRepository;
import com.levanov.pcshop.service.MonitorService;
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
@RequestMapping("/monitors")
@Tag(name = "Monitors - controller", description = "Взаимодействие с мониторами(добавить, найти, изменить, вывести все")
public class MonitorController {
    @Autowired
    private final MonitorRepository monitorRepository;
    @Autowired
    private final MonitorService monitorService;


    public MonitorController(MonitorRepository monitorRepository, MonitorService monitorService) {
        this.monitorRepository = monitorRepository;
        this.monitorService = monitorService;
    }

    @PostMapping()
    @Operation(
            summary = "Добавление монитора",
            description = "Позволяет добавить  монитор"
    )
    public Monitor save(@RequestBody Monitor monitor) {

        return monitorService.save(monitor);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление монитора",
            description = "Позволяет обновить монитор"
    )
    public ResponseEntity<?> partialUpdateMonitor(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody Monitor monitor
    ) throws URISyntaxException {

        if (monitor.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }
        if (!Objects.equals(id, monitor.getId())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);

        }

        if (!monitorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        }

        Optional<Monitor> result = monitorService.update(monitor);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "получение монитора по id",
            description = "Позволяет получить монитор по id"
    )

    public Optional<Monitor> getMonitorById(@PathVariable Long id) {

        Optional<Monitor> monitor = monitorService.findById(id);
        if (!monitorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return monitor;
    }


    @GetMapping()
    @Operation(
            summary = "Получение списка мониторов",
            description = "Позволяет получить список всех монитор"
    )
    public List<Monitor> getAllMonitors() {

        return monitorService.findAll();
    }
}
