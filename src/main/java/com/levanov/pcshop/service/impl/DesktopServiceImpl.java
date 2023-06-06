package com.levanov.pcshop.service.impl;

import com.levanov.pcshop.entity.Desktop;
import com.levanov.pcshop.repository.DesktopRepository;
import com.levanov.pcshop.service.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DesktopServiceImpl implements DesktopService {
@Autowired
DesktopRepository desktopRepository;

    @Override
    public Desktop save(Desktop desktop) {

        return desktopRepository.save(desktop);

    }

    @Override
    public Optional<Desktop> desktopUpdate(Desktop desktop) {
        return desktopRepository
                .findById(desktop.getId())
                .map(
                        existingDesktop -> {
                            if (desktop.getFormFactor() != null) {
                                existingDesktop.setFormFactor(desktop.getFormFactor());
                            }
                            if (desktop.getSerialNumber() != null) {
                                existingDesktop.setSerialNumber(desktop.getSerialNumber());
                            }
                            if (desktop.getManufacturer() != null) {
                                existingDesktop.setManufacturer(desktop.getManufacturer());
                            }
                            if (desktop.getPrice() != null) {
                                existingDesktop.setPrice(desktop.getPrice());
                            }
                            if (desktop.getNumberOfProductUnitsInStock() != null) {
                                existingDesktop.setNumberOfProductUnitsInStock(desktop.getNumberOfProductUnitsInStock());
                            }

                            return existingDesktop;
                        }
                )
                .map(desktopRepository::save);
    }

    @Override
    public List<Desktop> findAll() {
        return desktopRepository.findAll();
    }

    @Override
    public Optional<Desktop> findById(Long id) {
        return desktopRepository.findById(id);
    }
}
