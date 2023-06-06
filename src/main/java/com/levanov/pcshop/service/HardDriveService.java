package com.levanov.pcshop.service;


import com.levanov.pcshop.entity.HardDrive;

import java.util.List;
import java.util.Optional;

public interface HardDriveService {
    HardDrive save (HardDrive hardDrive);
    Optional<HardDrive> hddUpdate(HardDrive hardDrive);
    List<HardDrive> findAll();
    Optional<HardDrive> findById(Long id);
}
