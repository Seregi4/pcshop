package com.levanov.pcshop.controller;

import com.levanov.pcshop.entity.Desktop;
import com.levanov.pcshop.repository.DesktopRepository;
import com.levanov.pcshop.service.DesktopService;
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
@RequestMapping("/desktops")
@Tag(name = "Desktop - controller", description = "Взаимодействие с десктопами(добавить, найти, изменить, вывести все")
public class DesktopController {
    @Autowired
    private final DesktopService desktopService;
    private final DesktopRepository desktopRepository;

    public DesktopController(DesktopService desktopService, DesktopRepository desktopRepository) {
        this.desktopService = desktopService;
        this.desktopRepository = desktopRepository;
    }

    @PostMapping()
    @Operation(
            summary = "Добавление десктоп",
            description = "Позволяет добавить  десктоп"
    )
    public Desktop save(@RequestBody Desktop desktop) {
        return desktopService.save(desktop);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление десктоп",
            description = "Позволяет обновить данные десктоп"
    )
    public ResponseEntity<?> partialUpdateDesktop(
            @PathVariable(value = "id", required = true) final Long id,
            @RequestBody Desktop desktop
    ) throws URISyntaxException {

        if (desktop.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }
        if (!Objects.equals(id, desktop.getId())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);

        }

        if (!desktopRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        }

        Optional<Desktop> result = desktopService.desktopUpdate(desktop);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "получени десктопа по id",
            description = "Позволяет получить десктоп по id"
    )

    public Optional<Desktop> getDesktopById(@PathVariable Long id) {

        Optional<Desktop> desktop = desktopService.findById(id);
        if (!desktopRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return desktop;
    }


    @GetMapping()
    @Operation(
            summary = "Получение списка десктопов",
            description = "Позволяет получить список всех десктопов"
    )
    public List<Desktop> getAllHD() {

        return desktopService.findAll();
    }


}


