package com.levanov.pcshop.service;

import com.levanov.pcshop.entity.Desktop;

import java.util.List;
import java.util.Optional;

public interface DesktopService {
    Desktop save (Desktop desktop);
    Optional<Desktop> desktopUpdate(Desktop desktop);
    List<Desktop> findAll();
    Optional<Desktop> findById(Long id);
}
