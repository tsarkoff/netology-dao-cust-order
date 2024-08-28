package ru.netology.dao;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaoCustOrderApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DaoCustOrderApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    // CommandLineRunner allows to start actions right after App ready (e.g. fill DB, ect)
    @Override
    public void run(String... args) {
        System.out.println("App started, entering CommandLineRunner.run() method.");
    }
}
