package com.ust.pnp.arsenal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "personal_looks")
public class PersonalLook {
	@Id
	private String id;

	@JsonProperty("generatedLookId")
	private String generatedLookId;

	@JsonProperty("profileId")
	private String profileId;

	@JsonProperty("referenceLookId")
	private String referenceLookId;

	@JsonProperty("imageName")
	private String imageName;

	@JsonProperty("base64Image")
	private String base64Image;

	@JsonProperty("pmakeupoutimg")
	private String makeupBinaryImage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGeneratedLookId() {
		return generatedLookId;
	}

	public void setGeneratedLookId(String generatedLookId) {
		this.generatedLookId = generatedLookId;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getReferenceLookId() {
		return referenceLookId;
	}

	public void setReferenceLookId(String referenceLookId) {
		this.referenceLookId = referenceLookId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getMakeupBinaryImage() {
		return makeupBinaryImage;
	}

	public void setMakeupBinaryImage(String makeupBinaryImage) {
		this.makeupBinaryImage = makeupBinaryImage;
	}

}
