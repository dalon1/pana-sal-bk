package com.panasalbk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.panasalbk.app.util.StringUtils;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        StringUtils.printTitle("PANASAL BANK - DANNEL ALON - EBANKING");
        SpringApplication.run(App.class, args);
    }
}
