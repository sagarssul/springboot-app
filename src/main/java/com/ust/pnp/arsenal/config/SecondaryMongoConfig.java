package com.ust.pnp.arsenal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import static com.ust.pnp.arsenal.config.SecondaryMongoConfig.MONGO_TEMPLATE;

@Configuration
@EnableMongoRepositories(basePackages = "com.ust.pnp.arsenal.repo.secondary", mongoTemplateRef = MONGO_TEMPLATE)
public class SecondaryMongoConfig {
  protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
