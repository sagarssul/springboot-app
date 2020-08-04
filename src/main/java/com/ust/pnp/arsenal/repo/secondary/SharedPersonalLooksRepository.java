package com.ust.pnp.arsenal.repo.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.ust.pnp.arsenal.model.SharedPersonalLook;

public interface SharedPersonalLooksRepository extends MongoRepository<SharedPersonalLook, String> {
  @Query("{ 'pid' : ?0 }")
  public SharedPersonalLook findByPid(String pid);

}
