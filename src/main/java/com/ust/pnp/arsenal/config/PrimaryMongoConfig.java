package com.ust.pnp.arsenal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import static com.ust.pnp.arsenal.config.PrimaryMongoConfig.MONGO_TEMPLATE;

@Configuration
@EnableMongoRepositories(basePackages = "com.ust.pnp.arsenal.repo", mongoTemplateRef = MONGO_TEMPLATE)
public class PrimaryMongoConfig {
  protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
