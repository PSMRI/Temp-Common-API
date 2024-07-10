package com.iemr.common.data.customization;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "v_customizationdatafields")
@Data
public class V_CustomizationDataFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uuid", insertable = false)
	private String uuId;
	
	@Column(name = "ServiceLineId")
	@Expose
	private Integer serviceLineId;
	
	@Column(name = "ServiceLine")
	@Expose
	private String serviceLine;
	
	@Column(name = "stateid")
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
	
	@Column(name = "SectionID")
	@Expose
	private Integer sectionId;
	
	@Column(name = "SectionName")
	@Expose
	private String sectionName;
	
	@Column(name = "FieldName")
	@Expose
	private String fieldName;
	
	@Column(name = "Placeholder")
	@Expose
	private String placeholder;
	
	@Column(name = "FieldTypeID")
	@Expose
	private Integer fieldTypeId;
	
	@Column(name = "FieldType")
	@Expose
	private String fieldType;
	
	@Column(name = "Options")
	@Expose
	private String option;
	
	@Column(name = "AllowMin")
	@Expose
	private String allowMin;
	
	@Column(name = "AllowMax")
	@Expose
	private String allowMax;
	
	@Column(name = "IsRequired")
	@Expose
	private Boolean isRequired;
	
	@Column(name = "Rank")
	@Expose
	private Integer rank;
	
	@Column(name = "AllowText")
	@Expose
	private String allowText;
	
	@Column
	@Expose
	private String fieldTitle;
	
	@Transient
	private String[] options;

}
