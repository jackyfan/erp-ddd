package com.jackyfan.ddd.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class ErpApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ErpApplication.class, args);
    }
}
