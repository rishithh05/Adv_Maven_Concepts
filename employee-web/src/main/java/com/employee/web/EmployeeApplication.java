package com.employee.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.demo.DemoUtil;
@SpringBootApplication(scanBasePackages = {
        "com.employee.web",
        "com.employee.service"
})
@EntityScan("com.employee.service.entity")
@EnableJpaRepositories("com.employee.service.repository")
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}