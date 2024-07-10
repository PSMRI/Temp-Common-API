package com.iemr.common.data.customization;

import java.sql.Timestamp;

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
@Table(name = "t_registrationfields")
@Data
public class SectionAndFieldsMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Expose
	private Integer id;
	
	@Column(name = "SectionID")
	@Expose
	private Integer sectionId;
	
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
	
	@Column(name = "AllowMin")
	@Expose
    private Integer allowMin;
	
	@Column(name = "AllowMax")
	@Expose
	private Integer allowMax;
	
	@Column(name = "`Rank`")
	@Expose
	private Integer rank;
	
	@Column(name = "AllowText")
	@Expose
	private String allowText;
	
	@Column(name = "IsRequired")
	@Expose
	private Boolean isRequired;
	
	@Column(name = "Options")
	@Expose
	private String option;
	
	@Column(name = "IsEditable")
	@Expose
	private Boolean isEditable;
	
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
	
	@Column(name = "ServiceProviderID")
	@Expose
	private Integer serviceProviderId;
	
	@Expose
	@Column(name = "FieldTitle")
	private String fieldTitle;
	
	@Transient
	private String[] options;

}
