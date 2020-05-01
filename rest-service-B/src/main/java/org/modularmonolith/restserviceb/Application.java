package org.modularmonolith.restserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan(basePackages = {"org.modularmonolith"})
@ComponentScan(basePackages = {"org.modularmonolith"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
