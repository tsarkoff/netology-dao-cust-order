package ru.netology.dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DaoCustOrderRepositoryImpl implements DaoCustOrderRepository {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<?> getProducts(String customerName) {
        System.out.println("==> entityManager.createNativeQuery()");
        String sqlScript = read();
        sqlScript = sqlScript.replace("?1", customerName);
        Query query = entityManager.createNativeQuery(sqlScript);
        List<?> productNames = query.getResultList();
        productNames.forEach(System.out::println);
        return productNames;
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("select_products_for_customer.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void init() {
        Query q = entityManager.createNativeQuery("""
                insert into public.CUSTOMER (id, name, surname, age, phone_number, city, gender)
                values (1, 'Ivan', 'Ivanov', 18, '+7-095', 'Moscow', 'male'),
                       (2, 'Alexey', 'Petrov', 38, '+7-111', 'Vladivostok', 'male'),
                       (3, 'Jan', 'Chanson', 28, '+3-102', 'Helsinki', 'male'),
                       (4, 'Alexey', 'Popov', 48, '+7-222', 'Samara', 'male'),
                       (5, 'John', 'Jackson', 58, '+7-095', 'Moscow', 'male');
                """);
        int rows = q.executeUpdate();
        System.out.println("Updated CUSTOMER rows = " + rows);

        q = entityManager.createNativeQuery("""
                insert into public.CART (date, customer_id, product_name, amount, price)
                values ('2024-08-01', 1, 'Bread', 10, 80),
                       ('2024-08-05', 2, 'Milk', 5, 50),
                       ('2024-08-05', 2, 'Cake', 10, 950),
                       ('2024-07-02', 3, 'Butter', 500, 180),
                       ('2024-07-20', 4, 'Meat', 5, 550),
                       ('2024-07-20', 4, 'Bread', 5, 80),
                       ('2024-07-20', 4, 'Ketchup', 5, 120),
                       ('2024-08-15', 5, 'Cake', 3, 950);
                """);
        rows = q.executeUpdate();
        System.out.println("Updated CART rows = " + rows);
    }
}
