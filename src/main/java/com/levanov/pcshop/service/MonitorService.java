package com.levanov.pcshop.service;


import com.levanov.pcshop.entity.Monitor;

import java.util.List;
import java.util.Optional;

public interface MonitorService {
    Monitor save(Monitor monitor);

    Optional<Monitor> update(Monitor monitor);

    List<Monitor> findAll();

    Optional<Monitor> findById(Long id);
}
