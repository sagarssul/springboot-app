package com.ust.pnp.arsenal.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "looks")
public class CommonLook {
 // @Id
  private String id;

  @JsonProperty("image")
  private Binary image;
  
  @JsonProperty("category")
  private String category;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Binary getImage() {
    return image;
  }

  public void setImage(Binary image) {
    this.image = image;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
