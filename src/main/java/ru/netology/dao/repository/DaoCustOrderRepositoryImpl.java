package ru.netology.dao.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DaoCustOrderRepositoryImpl implements DaoCustOrderRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String sqlScriptFileName = "select_products_for_customer.sql";
    private String sqlScript;

    @Override
    public List<Product> getProducts(String customerName) {
        System.out.println("==> namedParameterJdbcTemplate.query()");
        sqlScript = read(sqlScriptFileName);
        List<Product> namedProducts = namedParameterJdbcTemplate.query(
                sqlScript,
                Collections.singletonMap("customer_name", customerName),
                (rs, rowNum) -> new Product(
                        rs.getString("product_name"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("date"),
                        rs.getInt("amount")
                ));
        namedProducts.forEach(System.out::println);
        return namedProducts;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
