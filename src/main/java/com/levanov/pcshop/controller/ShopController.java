package com.levanov.pcshop.controller;

import com.levanov.pcshop.entity.HardDrive;
import com.levanov.pcshop.entity.Product;
import com.levanov.pcshop.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Tag(name = "Shop - controller", description = "Показывает все товары")
public class ShopController {
    @Autowired
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping()
    @Operation(
            summary = "Получение списка товаров",
            description = "Позволяет получить список всех товаров"
    )
    public List<Product> getAllHD() {

        return shopService.getAllProducts();
    }

}
