package ru.netology.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.dao.repository.DaoCustOrderRepository;
import ru.netology.dao.repository.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaoCustOrderService {
    private final DaoCustOrderRepository daoRepository;

    public List<Product> getProducts(String customerName) {
        return daoRepository.getProducts(customerName);
    }
}
