package ru.netology.dao;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaoCustOrderApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DaoCustOrderApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
