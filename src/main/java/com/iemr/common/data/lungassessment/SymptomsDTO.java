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
package com.iemr.common.data.lungassessment;

import org.springframework.stereotype.Component;

@Component
public class SymptomsDTO {

	private Integer frequent_cough;
	private Integer sputum;
	private Integer cough_at_night;
	private Integer wheezing;
	private Integer pain_in_chest;
	private Integer shortness_of_breath;

	public Integer getFrequent_cough() {
		return frequent_cough;
	}

	public void setFrequent_cough(Integer frequent_cough) {
		this.frequent_cough = frequent_cough;
	}

	public Integer getSputum() {
		return sputum;
	}

	public void setSputum(Integer sputum) {
		this.sputum = sputum;
	}

	public Integer getCough_at_night() {
		return cough_at_night;
	}

	public void setCough_at_night(Integer cough_at_night) {
		this.cough_at_night = cough_at_night;
	}

	public Integer getWheezing() {
		return wheezing;
	}

	public void setWheezing(Integer wheezing) {
		this.wheezing = wheezing;
	}

	public Integer getPain_in_chest() {
		return pain_in_chest;
	}

	public void setPain_in_chest(Integer pain_in_chest) {
		this.pain_in_chest = pain_in_chest;
	}

	public Integer getShortness_of_breath() {
		return shortness_of_breath;
	}

	public void setShortness_of_breath(Integer shortness_of_breath) {
		this.shortness_of_breath = shortness_of_breath;
	}

}
