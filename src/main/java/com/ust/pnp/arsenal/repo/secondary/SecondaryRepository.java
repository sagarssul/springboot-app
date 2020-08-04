package com.ust.pnp.arsenal.repo.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ust.pnp.arsenal.model.CommonLook;

public interface SecondaryRepository extends MongoRepository<CommonLook, String> {

}
