/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.common.repository.email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.email.EmailNotification;
import com.iemr.common.data.email.EmailTemplate;

@Repository
@RestResource(exported = false)
public interface EmailRepository extends CrudRepository<EmailNotification, Long>{

	@Query("SELECT emailTemplate FROM EmailTemplate emailTemplate "
			+ "where emailTemplate.deleted = false ")
	EmailTemplate getEmailTemplate();
	
	@Query("SELECT authorityEmailID.emailID FROM AuthorityEmailID authorityEmailID "
			+ "where authorityEmailID.districtID = :districtID and "
			+ "authorityEmailID.deleted = false ")
	List getAuthorityEmailID(@Param("districtID") Integer districtID);
	
	@Query("select emailNotification from EmailNotification emailNotification "
			+ "where emailNotification.deleted <> true and emailNotification.emailID is not null and "
			+ "emailNotification.emailStatus = :emailStatus ")
	List<EmailNotification> findPendingEmailNotifications(@Param("emailStatus") Integer emailStatus);

	/*
	 * Du20091017
	 * get the email template by email type
	 */
	@Query("SELECT emailTemplate FROM EmailTemplate emailTemplate "
			+ "where emailTemplate.emailTemplateName = :emailType AND emailTemplate.deleted = false ")
	EmailTemplate getEmailTemplateByEmailType(@Param("emailType") String emailType);
	
}
