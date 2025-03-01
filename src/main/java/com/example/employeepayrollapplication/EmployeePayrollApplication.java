package com.example.employeepayrollapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll app started...", context.getEnvironment().getProperty("enviroment"));
		log.info("Employee Payroll DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
