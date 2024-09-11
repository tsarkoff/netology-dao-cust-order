package ru.netology.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.dao.repository.DaoCustOrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaoCustOrderService {
    private final DaoCustOrderRepository daoRepository;

    public void init() {
        daoRepository.init();
    }

    public List<?> getProducts(String customerName) {
        return daoRepository.getProducts(customerName);
    }
}
