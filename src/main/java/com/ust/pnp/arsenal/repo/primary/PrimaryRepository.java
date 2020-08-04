package com.ust.pnp.arsenal.repo.primary;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ust.pnp.arsenal.model.Look;

public interface PrimaryRepository extends MongoRepository<Look, String> {

}
