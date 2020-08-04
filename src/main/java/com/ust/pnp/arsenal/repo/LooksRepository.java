package com.ust.pnp.arsenal.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.ust.pnp.arsenal.model.Look;

public interface LooksRepository extends MongoRepository<Look, String> {
  @Query(value = "{ 'labels' : {$all : ?0 }}")
  public List<Look> findByLabels(String[] labels);
  
  @Query("{ 'category' : ?0 }")
  public List<Look> findByCategory(String category);
  
  @Query(value = "{'$and' :[{'profiles' : {$elemMatch: {'id': ?0}}}, {'category' : ?1}]}")
  public List<Look> findByProfileAndCategory(String profileId, String category);
  
  @Query(value = "{'$and' :[{'id' : ?0}, {'profiles' : {$elemMatch: {'id': ?1}}}]}")
  public Look findSimilarLooksByLookIdAndProfile(String lookId, String profileId);
  
}
