package com.anxing.anxingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class AnxingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnxingServiceApplication.class, args);
    }

}
