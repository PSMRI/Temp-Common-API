package com.iemr.common.data.facility;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="m_facility")
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FacilityID")
	@Expose
	private Integer facilityId;

	@Column(name = "FacilityName")
	@Expose
	private String facilityName;


	@Column(name = "FacilityDesc")
	@Expose
	private String facilityDesc;
	
	@Column(name = "FacilityCode")
	@Expose
	private String facilityCode;


	@Column(name = "FacilityTypeID")
	@Expose
	private Integer faciliyTypeId;
	
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapId;
	

	@Column(name = "IsMainFacility")
	@Expose
	private Boolean isMainFacility;

	@Column(name = "MainFacilityID")
	@Expose
	private Integer mainFacilityId;


	@Column(name = "eaushadi_facilityid")
	@Expose
	private Integer eAusadhiFacilityId;
	

	@Column(name = "eaushada_facilityid")
	@Expose
	private String eAusadhaFacilityId;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	@Expose
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;


}
