package com.ust.pnp.arsenal.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ust.pnp.arsenal.api","com.ust.pnp.arsenal.manager",
        "com.ust.pnp.arsenal.config", "com.ust.pnp.arsenal.repo", "com.ust.pnp.arsenal.repo.secondary"})

public class ArsenalLooksServiceMain {

    public static void main(String args[]){
        SpringApplication.run(ArsenalLooksServiceMain.class, args);
    }
}
