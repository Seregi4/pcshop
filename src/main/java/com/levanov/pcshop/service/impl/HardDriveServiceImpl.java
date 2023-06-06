package com.levanov.pcshop.service.impl;

import com.levanov.pcshop.entity.HardDrive;
import com.levanov.pcshop.repository.HardDriveRepository;
import com.levanov.pcshop.service.HardDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HardDriveServiceImpl implements HardDriveService {
    @Autowired
    HardDriveRepository hardDriveRepository;

    @Override
    public HardDrive save(HardDrive hardDrive) {
        return hardDriveRepository.save(hardDrive);
    }

    @Override
    public Optional<HardDrive> hddUpdate(HardDrive hardDrive) {
        return hardDriveRepository
                .findById(hardDrive.getId())
                .map(
                        existingHardDrive -> {
                            if (hardDrive.getValue() != null) {
                                existingHardDrive.setValue(hardDrive.getValue());
                            }
                            if (hardDrive.getSerialNumber() != null) {
                                existingHardDrive.setSerialNumber(hardDrive.getSerialNumber());
                            }
                            if (hardDrive.getManufacturer() != null) {
                                existingHardDrive.setManufacturer(hardDrive.getManufacturer());
                            }
                            if (hardDrive.getPrice() != null) {
                                existingHardDrive.setPrice(hardDrive.getPrice());
                            }
                            if (hardDrive.getNumberOfProductUnitsInStock() != null) {
                                existingHardDrive.setNumberOfProductUnitsInStock(hardDrive.getNumberOfProductUnitsInStock());
                            }

                            return existingHardDrive;
                        }
                )
                .map(hardDriveRepository::save);
    }

    @Override
    public List<HardDrive> findAll() {
        return hardDriveRepository.findAll();
    }

    @Override
    public Optional<HardDrive> findById(Long id) {
        return hardDriveRepository.findById(id);
    }
}
