package com.ust.pnp.arsenal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MultipleMongoConfig {
  
  @Autowired
  private Environment env;
  
  @Primary
  @Bean("primary")
  @ConfigurationProperties(prefix = "spring.data.mongodb.primary")
  public MongoProperties getPrimary() {
      return new MongoProperties();
  }

  @Bean("secondary")
  @ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
  public MongoProperties getSecondary() {
      return new MongoProperties();
  }
  
  @Primary
  @Bean(PrimaryMongoConfig.MONGO_TEMPLATE)
  public MongoTemplate primaryMongoTemplate() throws Exception {
      return new MongoTemplate(primaryFactory(getPrimary()));
  }
  @Bean(SecondaryMongoConfig.MONGO_TEMPLATE)
  public MongoTemplate secondaryMongoTemplate() throws Exception {
      return new MongoTemplate(secondaryFactory(getSecondary()));
  }
  @Bean
  @Primary
  public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
      return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
              mongo.getDatabase());
  }

  @Bean
  public MongoDbFactory secondaryFactory(final MongoProperties mongo) throws Exception {
      return new SimpleMongoDbFactory(new MongoClientURI(env.getProperty("spring.data.mongodb.secondary.uri")));
  }
}
