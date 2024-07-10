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
@Table(name = "t_MapSectionProjects")
@Data
public class SectionProjectMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Expose
	private Integer id;
	
	@Column(name = "ProjectID")
	@Expose
	private Integer projectId;
	
	@Column(name = "ProjectName")
	@Expose
	private String projectName;
	
	@Column(name = "SectionID")
	@Expose
	private Integer sectionId;
	
	@Column(name = "SectionName")
	@Expose
	private String sectionName;
	
	@Column(name = "serviceProviderId")
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
