package com.niudingfeng.financialplanner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.niudingfeng.financialplanner.mapper")
public class FinancialPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialPlannerApplication.class, args);
	}
}
