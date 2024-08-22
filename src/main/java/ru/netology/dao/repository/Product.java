package ru.netology.dao.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String productName;
    private String customerName;
    private String customerSurname;
    private String date;
    private int amount;
}
