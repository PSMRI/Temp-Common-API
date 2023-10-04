package com.iemr.common.repo.esanjeevani;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.door_to_door_app.V_doortodooruserdetails;
@Repository
@RestResource(exported = false)
public interface ESanjeevaniRepo extends CrudRepository<V_doortodooruserdetails, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT BenDetailsId AS benDetailsId, BenAddressId AS benAddressId,  BenContactsId AS benContactsId  FROM db_identity.i_beneficiarymapping WHERE BenRegId = :benRegID")
	public List<Object[]> getBeneficiaryMappingIds(@Param("benRegID") Long benRegID);


	@Query(nativeQuery = true, value = "SELECT FirstName, LastName, MiddleName, Gender, DOB FROM db_identity.i_beneficiarydetails WHERE BeneficiaryDetailsId = :benDetailsId")
	public List<Object[]> getBeneficiaryDeatils(@Param("benDetailsId") BigInteger benDetailsId);
	
	@Query(nativeQuery = true, value = "SELECT PreferredPhoneNum FROM db_identity.i_beneficiarycontacts WHERE BenContactsID = :benContactId")
	public String getBeneficiaryContactDetails(@Param("benContactId") BigInteger benContactId);
	
	@Query(nativeQuery = true, value = "SELECT CurrCountryId, CurrCountry, CurrStateId, CurrState, CurrDistrictId, CurrDistrict, CurrSubDistrictId, CurrSubDistrict, "
			+ "CurrAddrLine1, CurrPinCode FROM db_identity.i_beneficiaryaddress WHERE BenAddressID = :benAddressId")
	public List<Object[]> getBeneficiaryAddressDetails(@Param("benAddressId") BigInteger benAddressId);
	
	@Query(nativeQuery = true, value = "SELECT HealthID AS healthId, HealthIDNumber AS healthIdNumber FROM db_iemr.m_benhealthidmapping WHERE BeneficiaryRegID = :benRegID")
	public List<Object[]> getBeneficiaryHealthIdDeatils(@Param("benRegID") Long benRegID);
	
	@Query(nativeQuery = true, value = "SELECT GovtStateID FROM db_iemr.m_state WHERE StateID = :stateId ")
	public Integer getGovStateId(@Param("stateId") Integer stateId);
	
	@Query(nativeQuery = true, value = "SELECT GovtDistrictID FROM db_iemr.m_district WHERE DistrictID = :districtId ")
	public Integer getGovDistrictId(@Param("districtId") Integer districtId);
	
	@Query(nativeQuery = true, value = "SELECT GovSubDistrictID,GovVillageID,VillageName FROM db_iemr.m_districtbranchmapping WHERE DistrictBranchID = :subDistrictId ")
	public List<Object[]> getGovSubDistrictId(@Param("subDistrictId") Integer subDistrictId);
	
	@Query(nativeQuery = true, value = "SELECT CountryCode FROM db_iemr.m_country WHERE CountryID = :countryID ")
	public String getGovCountyId(@Param("countryID") Integer countryID);
}
