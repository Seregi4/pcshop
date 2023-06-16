package com.levanov.pcshop.service.impl;


import com.levanov.pcshop.entity.Laptop;
import com.levanov.pcshop.repository.LaptopRepository;
import com.levanov.pcshop.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    LaptopRepository laptopRepository;


    @Override
    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Optional<Laptop> update(Laptop laptop) {
        return laptopRepository
                .findById(laptop.getId())
                .map(
                        existingLaptop -> {
                            if (laptop.getInch() != null) {
                                existingLaptop.setInch(laptop.getInch());
                            }
                            if (laptop.getSerialNumber() != null) {
                                existingLaptop.setSerialNumber(laptop.getSerialNumber());
                            }
                            if (laptop.getManufacturer() != null) {
                                existingLaptop.setManufacturer(laptop.getManufacturer());
                            }
                            if (laptop.getPrice() != null) {
                                existingLaptop.setPrice(laptop.getPrice());
                            }
                            if (laptop.getNumberOfProductUnitsInStock() != null) {
                                existingLaptop.setNumberOfProductUnitsInStock(laptop.getNumberOfProductUnitsInStock());
                            }

                            return existingLaptop;
                        }
                )
                .map(laptopRepository::save);
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findById(Long id) {
        return laptopRepository.findById(id);

    }
}
