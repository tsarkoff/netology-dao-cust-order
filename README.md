# 3. Добавление функционала Миграции (liquibase)
1. Запустить приложение с параметрами:
   - spring.jpa.hibernate.ddl-auto=update
   - spring.liquibase.enabled=false
2. Произойдет создание (Хибернейтом) таблиц Cart (как и ранее) и Customer с новыми полем Gender, добавленным в Entity и в метод GET /init
3. ПереЗапустить приложение, изменив параметр spring.liquibase.enabled=true
4. Произойдет миграция таблицы Cart с добавлением поля Price из Change-Set'а с наличием Цены в методе GET /init
5. Лог миграции запишется в таблицу databasechangelog
6. Вызвать метод GET http://127.0.0.1:8080/products/init
7. Проверить в таблицах наличие данных для полей Customer.Gender и СCart.Price
8. Вызвать метод : GET http://127.0.0.1:8080/products/fetch-product?name=AlexeY для получения Наименований Товаров, заказанных Алексеями 
---

# 2. Замена JDBС (NamedParameterJdbcTemplate) на Hibernate (EntityManager)
1. Все аналогично пунктам из параграфа 1 ниже, но:
2. Перед вызовом метода : GET http://127.0.0.1:8080/products/fetch-product?name=AlexeY
   3. Необходимо наполнить таблицы БД запросм : GET http://127.0.0.1:8080/products/init 
# 1. Работа с Сервисом получения списка заказанных Клиентом Продуктов
1. Запустить приложение DaoCustOrderApp
2. Автоматичски запустится докер-контейнер с Postgres DB
3. В Postgres DB создастся схема contacts, таблицы CUSTOMER и ORDERS наполнятся данными 
4. Открыть файл test/request.http и выполнить GET запрос (или выполнить запрос из браузера)
5. Остановить приложение 
6. Открыть файл compose.yaml, раскомментировать service: products
7. Запустить приложение DaoCustOrderApp
8. Автоматически создадутся два контейнера с БД и сервисом DaoCustOrderApp
   - В логах докер-контейнера products-1 увидеть, что Бины Спринг приложения не создаются - ошибка не ясна>
   - Попытки перенести создание Бинов вручную внутри JavaConfig.java не помогли  
--------------------------

# 8.3 - Задача «Слой DAO (Data Access Object)»

## Описание

Попрактикуемся в работе со Spring JDBC, параллельно закрепляя уже пройденные темы.

Вам надо написать приложение для работы с БД, используя скрипты, которые вы написали при выполнении [второго задания](../../sql-agg/task/README.md).

**Шаг 1.** Создайте Spring Boot приложение с зависимостями на два стартера — `spring-boot-starter-jdbc` и `spring-boot-starter-web`.

**Шаг 2.** Перенесите скрипт создания таблицы в файл `schema.sql`, чтобы Spring Boot автоматически создавал таблицу.

**Шаг 3.** Перенесите скрипт запроса из второго задания в папку `resources`. Перепишите скрипт так, чтобы он возвращал `product_name` для именованного параметра `name`(а не только для `alexey`), который вы будете передавать в методы выполнения скрипта `NamedParameterJdbcTemplate` вместе со скриптом запроса.

**Шаг 4.** Напишите репозиторий для работы с БД.

- Создайте класс и пометьте его аннотацией Repository, либо создайте бин репозитория в Java Config классе.
- Добавьте в поле класса String, которое содержит ваше содержание вашего скрипта. Само содержание вы можете считать с помощью кода ниже. Вам надо будет передать в метод `read` название вашего скрипта, который лежит в папке `resources`. Например так: `read(myScript.sql)`.
- Создайте метод `getProductName(String name)`, который будет принимать имя и возвращать название продукта из базы данных.

```java
private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
``` 

**Шаг 5.** Напишите контроллер с методом-обработчиком GET-метода запроса с маппингом на endpoint `/products/fetch-product`. В query params запроса будет приходить строковый параметр `name`, который вам надо будет передавать дальше в репозиторий. То есть, ваш метод должен уметь обрабатывать запрос вида `localhost:8080/products/fetch-product?name=Ivan`.
Контроллер должен будет возвращать название продукта, которое он получит от репозитория.

**Шаг 6**. Написанный код выложите в отдельный репозиторий на GitHub и прикрепите ссылку на него в комментарий к домашнему заданию.