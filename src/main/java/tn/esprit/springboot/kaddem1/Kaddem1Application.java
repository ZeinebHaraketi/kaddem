package tn.esprit.springboot.kaddem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"tn.esprit.springboot.kaddem1.repository"})
@EntityScan(basePackages ={"tn.esprit.springboot.kaddem1.entity"})
@ComponentScan(basePackages = {"tn.esprit.springboot.kaddem1.controller","tn.esprit.springboot.kaddem1.services"})

public class Kaddem1Application {


    public static void main(String[] args) {
        SpringApplication.run(Kaddem1Application.class, args);
    }

}
