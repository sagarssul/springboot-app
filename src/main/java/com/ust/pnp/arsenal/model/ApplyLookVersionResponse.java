package com.ust.pnp.arsenal.model;

public class ApplyLookVersionResponse {

	private String id;
	private String base64Image;
	private String version;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String string) {
		this.version = string;
	}

}
