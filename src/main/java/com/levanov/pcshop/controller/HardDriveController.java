package com.levanov.pcshop.controller;


import com.levanov.pcshop.entity.HardDrive;
import com.levanov.pcshop.repository.HardDriveRepository;
import com.levanov.pcshop.service.HardDriveService;
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
@RequestMapping("/harddrives")
@Tag(name = "HardDrive - controller", description = "Взаимодействие с жесткими дисками(добавить, найти, изменить, вывести все")
public class HardDriveController {

    @Autowired
    private final HardDriveRepository hardDriveRepository;
    @Autowired
    private final HardDriveService hardDriveService;


    public HardDriveController(HardDriveRepository hardDriveRepository, HardDriveService hardDriveService) {
        this.hardDriveRepository = hardDriveRepository;
        this.hardDriveService = hardDriveService;
    }

    @PostMapping()
    @Operation(
            summary = "Добавление жесткого диска",
            description = "Позволяет добавить  жесткий диск"
    )
    public HardDrive save(@RequestBody HardDrive hardDrive) {
        return hardDriveService.save(hardDrive);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление жесткого диска",
            description = "Позволяет обновить жесткий диск"
    )
    public ResponseEntity<?> partialUpdateHD(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody HardDrive hardDrive
    ) throws URISyntaxException {

        if (hardDrive.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }
        if (!Objects.equals(id, hardDrive.getId())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);

        }

        if (!hardDriveRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        }

        Optional<HardDrive> result = hardDriveService.hddUpdate(hardDrive);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "получение жесткого диска по id",
            description = "Позволяет получить жесткий диск по id"
    )

    public Optional<HardDrive> getHDById(@PathVariable Long id) {

        Optional<HardDrive> hardDrive = hardDriveService.findById(id);
        if (!hardDriveRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return hardDrive;
    }


    @GetMapping()
    @Operation(
            summary = "Получение списка жестких дисков",
            description = "Позволяет получить список всех жестких дисков"
    )
    public List<HardDrive> getAllHD() {

        return hardDriveService.findAll();
    }
}
