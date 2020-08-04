package com.ust.pnp.arsenal.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("personallooks")
public class SharedPersonalLook {
	private String id;
	private String pid;
	private Binary pmakeupoutimg;
	private String looksid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Binary getPmakeupoutimg() {
		return pmakeupoutimg;
	}

	public void setPmakeupoutimg(Binary pmakeupoutimg) {
		this.pmakeupoutimg = pmakeupoutimg;
	}

	public String getLooksid() {
		return looksid;
	}

	public void setLooksid(String looksid) {
		this.looksid = looksid;
	}

}
