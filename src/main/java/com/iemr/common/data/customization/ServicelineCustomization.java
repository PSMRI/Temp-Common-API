package com.iemr.common.data.customization;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_projectservicelinemapping")
@Data
public class ServicelineCustomization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Expose
	private Integer id;
	

	@Column(name = "ServiceLineId")
	@Expose
	private Integer serviceLineId;
	
	@Column(name = "ServiceLine")
	@Expose
	private String serviceLine;
	
	@Column(name = "StateId")
	@Expose
	private Integer stateId;
	
	@Column(name = "StateName")
	@Expose
	private String stateName;
	
	@Column(name = "DistrictID")
	@Expose
	private Integer districtId;
	
	@Column(name = "DistrictName")
	@Expose
	private String districtName;
	
	@Column(name = "BlockID")
	@Expose
    private Integer blockId;
	
	@Column(name = "BlockName")
	@Expose
	private String blockName;
	
	@Column(name = "ProjectID")
	@Expose
	private Integer projectId;
	
	@Column(name = "ProjectName")
	@Expose
	private String projectName;
	
	@Column(name = "ServiceProviderID")
	@Expose
	private Integer serviceProviderId;
	
	@Column(name = "Deleted")
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;


}
