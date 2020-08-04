package com.ust.pnp.arsenal.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "profile")
public class CommonProfile {
  String id;
  Binary profileImage;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Binary getProfileImage() {
    return profileImage;
  }
  public void setProfileImage(Binary profileImage) {
    this.profileImage = profileImage;
  }
  
}
