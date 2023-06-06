package com.levanov.pcshop.repository;

import com.levanov.pcshop.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
