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
package com.iemr.common.model.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iemr.common.data.email.StockAlertData;
import com.iemr.common.utils.exception.IEMRException;

public class ExcelHelper {
	// public static String TYPE =
	// "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] CriteriaHEADERs = { "Filter Name", "Value" };
	static String SHEET = "Users";

	public static ByteArrayInputStream tutorialsToExcel(String[] headers, List<Objects[]> result, String sheet1,
			Criteria criteria) throws IEMRException {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet criteriaSheet = workbook.createSheet("Criteria");

			// Removing milliseconds from timestamp
			criteria.setStart_Date(criteria.getStart_Date().replaceAll("\\.\\d+", ""));
			criteria.setEnd_Date(criteria.getEnd_Date().replaceAll("\\.\\d+", ""));

			// Header
			Row headerRowCriteria = criteriaSheet.createRow(0);
			for (int col = 0; col < CriteriaHEADERs.length; col++) {
				Cell cell = headerRowCriteria.createCell(col);
				cell.setCellValue(CriteriaHEADERs[col]);
			}
			int criteriaRowIndex = 1;
			if (sheet1.equalsIgnoreCase("qareport")) {
				for (int j = 0; j < 4; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else if (j == 1) {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					} else if (j == 2) {
						row.createCell(0).setCellValue("RoleID");
						row.createCell(1).setCellValue(criteria.getRoleID());
					} else {
						row.createCell(0).setCellValue("AgentID");
						row.createCell(1).setCellValue(criteria.getAgentID());
					}
				}
			} else if (sheet1.equalsIgnoreCase("Call_Summary_Report")) {
				for (int j = 0; j < 7; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else if (j == 1) {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					} else if (j == 2) {
						row.createCell(0).setCellValue("Service");
						row.createCell(1).setCellValue(criteria.getService());
					} else if (j == 3) {
						row.createCell(0).setCellValue("RoleID");
						row.createCell(1).setCellValue(criteria.getRoleID());
					} else if (j == 4) {
						row.createCell(0).setCellValue("AgentID");
						row.createCell(1).setCellValue(criteria.getAgentID());
					} else if (j == 5) {
						row.createCell(0).setCellValue("CallTypeName");
						row.createCell(1).setCellValue(criteria.getCallTypeName());
					} else {
						row.createCell(0).setCellValue("CallTypeId");
						row.createCell(1).setCellValue(criteria.getCallTypeID());
					}
				}
			}

			else if (sheet1.equalsIgnoreCase("Sexual_Orientation_Report")) {
				for (int j = 0; j < 5; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("State");
						row.createCell(1).setCellValue(criteria.getState());

					} else if (j == 1) {
						row.createCell(0).setCellValue("District");
						row.createCell(1).setCellValue(criteria.getDistrict());

					} else if (j == 2) {
						row.createCell(0).setCellValue("Sexual_Orientation");
						row.createCell(1).setCellValue(criteria.getSexual_Orientation());

					} else if (j == 3) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					}
				}
			} else if (sheet1.equalsIgnoreCase("District_Wise_Call_Volume_Report")) {
				for (int j = 0; j < 2; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					}
				}

			} else if (sheet1.equalsIgnoreCase("Call_Type_Report")) {
				for (int j = 0; j < 9; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else if (j == 1) {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					} else if (j == 2) {
						row.createCell(0).setCellValue("State");
						row.createCell(1).setCellValue(criteria.getState());
					} else if (j == 3) {
						row.createCell(0).setCellValue("District");
						row.createCell(1).setCellValue(criteria.getDistrict());
					} else if (j == 4) {
						row.createCell(0).setCellValue("Language");
						row.createCell(1).setCellValue(criteria.getLanguage());
					} else if (j == 5) {
						row.createCell(0).setCellValue("Call_Type");
						row.createCell(1).setCellValue(criteria.getCall_Type());
					} else if (j == 6) {
						row.createCell(0).setCellValue("Call_Sub_Type");
						row.createCell(1).setCellValue(criteria.getCall_Sub_Type());
					} else if (j == 7) {
						row.createCell(0).setCellValue("Gender");
						row.createCell(1).setCellValue(criteria.getGender());
					} else {
						row.createCell(0).setCellValue("Sexual_Orientation");
						row.createCell(1).setCellValue(criteria.getSexual_Orientation());
					}
				}
			} else if (sheet1.equalsIgnoreCase("Gender_Distribution_Report")) {
				for (int j = 0; j < 5; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("State");
						row.createCell(1).setCellValue(criteria.getState());
					} else if (j == 1) {
						row.createCell(0).setCellValue("District");
						row.createCell(1).setCellValue(criteria.getDistrict());
					} else if (j == 2) {
						row.createCell(0).setCellValue("Gender");
						row.createCell(1).setCellValue(criteria.getGender());
					} else if (j == 3) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					}
				}
			} else if (sheet1.equalsIgnoreCase("Language_Distribution_Report")) {
				for (int j = 0; j < 5; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("State");
						row.createCell(1).setCellValue(criteria.getState());
					} else if (j == 1) {
						row.createCell(0).setCellValue("District");
						row.createCell(1).setCellValue(criteria.getDistrict());
					} else if (j == 2) {
						row.createCell(0).setCellValue("Language");
						row.createCell(1).setCellValue(criteria.getLanguage());
					} else if (j == 3) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					}
				}
			}

			else if (sheet1.equalsIgnoreCase("Caller_Age_Group_Report")) {
				for (int j = 0; j < 5; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("State");
						row.createCell(1).setCellValue(criteria.getState());
					} else if (j == 1) {
						row.createCell(0).setCellValue("District");
						row.createCell(1).setCellValue(criteria.getDistrict());
					} else if (j == 2) {
						row.createCell(0).setCellValue("Caller_Age_Group");
						row.createCell(1).setCellValue(criteria.getCallerAgeGroup());
					} else if (j == 3) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					}
				}
			} else {
				for (int j = 0; j < 3; j++) {
					Row row = criteriaSheet.createRow(criteriaRowIndex++);
					if (j == 0) {
						row.createCell(0).setCellValue("Start_Date");
						row.createCell(1).setCellValue(criteria.getStart_Date());
					} else if (j == 1) {
						row.createCell(0).setCellValue("End_Date");
						row.createCell(1).setCellValue(criteria.getEnd_Date());
					} else {
						row.createCell(0).setCellValue("Service");
						row.createCell(1).setCellValue(criteria.getService());
					}
				}
			}
			Sheet sheet = workbook.createSheet("Report");

			// Header
			Row headerRow = sheet.createRow(0);
			for (int col = 0; col < headers.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(headers[col]);
			}
			int rowIdx = 1;
			int size = 0;
			int sno = 1, a = 1;
			for (Object[] obj : result) {
				Row row = sheet.createRow(rowIdx++);
				size = obj.length;
				row.createCell(0).setCellValue(sno++);
				a = 1;
				for (int i = 0; i < size; i++) {
					Boolean isDate = isValidDate(obj[i] != null ? obj[i].toString() : "");
					if (isDate) {
						row.createCell(a)
								.setCellValue(obj[i] != null ? obj[i].toString().replaceAll("\\.\\d+", "") : "");
					} else
						row.createCell(a).setCellValue(obj[i] != null ? obj[i].toString() : "");
					a++;
				}
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			throw new IEMRException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	public static boolean isValidDate(String inDate) {

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {

			Date date = inputDateFormat.parse(inDate);
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public static byte[] InventoryDataToExcel(List<StockAlertData> list) throws Exception {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet("Stock Alert");

			// Header
			Row headerRow = sheet.createRow(0);
			Cell cell = headerRow.createCell(0);
			cell.setCellValue("Drug Name");
			cell = headerRow.createCell(1);
			cell.setCellValue("Stock Added");
			cell = headerRow.createCell(2);
			cell.setCellValue("Stock In Hand");
			cell = headerRow.createCell(3);
			cell.setCellValue("% Stock Consumed");
			cell = headerRow.createCell(4);
			cell.setCellValue("Facility Name");
			cell = headerRow.createCell(5);
			cell.setCellValue("District Name");
			// Adding rows
			int rowIndex = 1, a = 0;
			for (StockAlertData obj : list) {
				a=0;
				Row row = sheet.createRow(rowIndex++);
				row.createCell(a++).setCellValue(obj.getItemName());
				row.createCell(a++).setCellValue(obj.getTotalquantity());
				row.createCell(a++).setCellValue(obj.getQuantityInHand());
				row.createCell(a++).setCellValue(obj.getQuantityinhandPercent());
				row.createCell(a++).setCellValue(obj.getFacilityName());
				row.createCell(a++).setCellValue(obj.getDistrictName());
			}
			workbook.write(out);
			return out.toByteArray();
		} catch (Exception e) {
			throw new Exception("fail to import data to Excel file: " + e.getMessage());
		}
	}
}