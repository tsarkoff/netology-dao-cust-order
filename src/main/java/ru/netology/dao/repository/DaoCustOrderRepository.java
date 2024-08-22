package ru.netology.dao.repository;

import java.util.List;

public interface DaoCustOrderRepository {
    List<Product> getProducts(String customerName);
}
