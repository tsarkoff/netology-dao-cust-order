package ru.netology.dao.repository;

import java.util.List;

public interface DaoCustOrderRepository {
    void init();
    List<?> getProducts(String customerName);
}
