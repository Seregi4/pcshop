package com.levanov.pcshop.service;


import com.levanov.pcshop.entity.Laptop;

import java.util.List;
import java.util.Optional;

public interface LaptopService {
    Laptop save (Laptop laptop);
    Optional<Laptop> update(Laptop laptop);
    List<Laptop> findAll();
    Optional<Laptop> findById(Long id);
}
