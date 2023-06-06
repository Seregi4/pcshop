package com.levanov.pcshop.service.impl;


import com.levanov.pcshop.entity.Monitor;
import com.levanov.pcshop.repository.MonitorRepository;
import com.levanov.pcshop.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    MonitorRepository monitorRepository;

    @Override
    public Monitor save(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    @Override
    public Optional<Monitor> update(Monitor monitor) {
        return monitorRepository
                .findById(monitor.getId())
                .map(
                        existingMonitor -> {
                            if (monitor.getDiagonal() != null) {
                                existingMonitor.setDiagonal(monitor.getDiagonal());
                            }
                            if (monitor.getSerialNumber() != null) {
                                existingMonitor.setSerialNumber(monitor.getSerialNumber());
                            }
                            if (monitor.getManufacturer() != null) {
                                existingMonitor.setManufacturer(monitor.getManufacturer());
                            }
                            if (monitor.getPrice() != null) {
                                existingMonitor.setPrice(monitor.getPrice());
                            }
                            if (monitor.getNumberOfProductUnitsInStock() != null) {
                                existingMonitor.setNumberOfProductUnitsInStock(monitor.getNumberOfProductUnitsInStock());
                            }

                            return existingMonitor;
                        }
                )
                .map(monitorRepository::save);
    }

    @Override
    public List<Monitor> findAll() {
        return monitorRepository.findAll();
    }

    @Override
    public Optional<Monitor> findById(Long id) {
        return monitorRepository.findById(id);
    }
}
