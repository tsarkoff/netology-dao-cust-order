package ru.netology.dao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.dao.service.DaoCustOrderService;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class DaoCustOrderController {
    private final DaoCustOrderService service;

    @GetMapping("/init")
    public void init() {
        service.init();
    }

    @GetMapping("/fetch-product")
    public List<?> getProducts(@RequestParam("name") String customerName) {
        return service.getProducts(customerName);
    }
}
