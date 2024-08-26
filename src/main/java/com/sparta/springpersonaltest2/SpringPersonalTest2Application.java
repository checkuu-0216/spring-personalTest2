package com.sparta.springpersonaltest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringPersonalTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringPersonalTest2Application.class, args);
    }

}
