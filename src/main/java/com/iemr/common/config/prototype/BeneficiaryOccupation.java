package com.iemr.common.config.prototype;

public class BeneficiaryOccupation {
	private Long occupationID;
	private String occupationType;
	private Boolean deleted;
	private String createdby;
	private String modifiedby;
	private String key;
	private String operation;

	public Long getOccupationID() {
		return occupationID;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getCreatedby() {
		return createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public String getKey() {
		return key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOccupationID(Long occupationID) {
		this.occupationID = occupationID;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
