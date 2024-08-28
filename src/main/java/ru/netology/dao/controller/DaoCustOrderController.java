package ru.netology.dao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.dao.service.DaoCustOrderService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class DaoCustOrderController {
    private final DaoCustOrderService service;

    @RequestMapping(
            value = "/init",
            method = RequestMethod.GET
    )
    public void init() {
        service.init();
    }

    @RequestMapping(
            value = "/fetch-product",
            method = RequestMethod.GET
    )
    public List<?> getProducts(@RequestParam("name") String customerName) {
        return service.getProducts(customerName);
    }
}
