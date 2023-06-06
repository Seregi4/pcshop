package com.levanov.pcshop.service.impl;

import com.levanov.pcshop.entity.Product;
import com.levanov.pcshop.repository.ShopRepository;
import com.levanov.pcshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepository shopRepository;

    @Override
    public List<Product> getAllProducts() {

        return shopRepository.findAll();
    }
}
