package com.ust.pnp.arsenal.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.ust.pnp.arsenal.model.PersonalLook;

public interface PersonalLookRepository extends MongoRepository<PersonalLook, String> {
  @Query("{ 'profileId' : ?0 }")
  public List<PersonalLook> findPersonalLooksByProfile(String profileId);

}
