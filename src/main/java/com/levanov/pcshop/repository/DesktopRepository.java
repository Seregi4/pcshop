package com.levanov.pcshop.repository;


import com.levanov.pcshop.entity.Desktop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop,Long> {

}
