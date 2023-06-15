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
package com.iemr.common.notification.util;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class OutputResponse
{
	private static final Logger logger = LoggerFactory.getLogger("com.iemr.common.notification.util.OutputResponse");

	@Expose
	private JsonElement response;

	/*
	 * Response JSON: { "methodName" : "<Method_Name>", "dataObjectType" : "Object_Name", "dataJsonType		:	"object
	 * or array or primitive or null" "data" : "<json of Object_Name>", "statusCode" : <number>, "statusMessage" :
	 * "<message>" "statusMessageLong" : "<messageLong> }
	 */

	public static class Builder
	{
		private String methodName;
		private String dataObjectType;
		private String dataJsonType;
		private String data;
		private Integer statusCode;
		private String statusMessage;
		private String statusMessageLong;

		public static final int SUCCESS = 200;
		public static final int GENERIC_FAILURE = 5000;
		public static final int OBJECT_FAILURE = 5001;
		public static final int USERID_FAILURE = 5002;
		public static final int PASSWORD_FAILURE = 5003;
		public static final int PRIVILEGE_FAILURE = 5004;
		public static final int CODE_EXCEPTION = 5005;
		public static final int ENVIRONMENT_EXCEPTION = 5006;
		public static final int PARSE_EXCEPTION = 5007;
		public static final int MANDATORY_PARAMS_MISSING = 5008;
		public static final int ILLEGAL_ACTION = 5009;

		public Builder()
		{
			this.methodName = "";
			this.dataObjectType = "";
			this.dataJsonType = "";
			this.data = "";
			this.statusCode = /*new Integer(0)*/0;
			this.statusMessage = "";
			this.statusMessageLong = "";
		}

		public Builder setMethodName(String str)
		{
			methodName = str;
			return this;
		}

		public Builder setDataObjectType(String str)
		{
			dataObjectType = str;
			return this;
		}

		public Builder setDataJsonType(String str)
		{
			dataJsonType = str;
			return this;
		}

		public Builder setData(String str) throws JsonParseException, JsonSyntaxException
		{
			// JsonElement element = new JsonParser().parse(str);
			data = str;
			return this;
		}

		public Builder setStatusCode(Integer code)
		{
			statusCode = code;
			return this;
		}

		public Builder setStatusMessage(String str)
		{
			statusMessage = str;
			return this;
		}

		public Builder setStatusMessageLong(String str)
		{
			statusMessageLong = str;
			return this;
		}

		public Builder setErrorMessage(Throwable thrown)
		{

			Date currDate = Calendar.getInstance().getTime();
			logger.info("error happened due to " + thrown.getClass().getSimpleName() + " at " + currDate.toString());
			switch (thrown.getClass().getSimpleName())
			{
				case "MissingMandatoryFieldsException":
					statusCode = MANDATORY_PARAMS_MISSING;
					statusMessage = "Missing Mandatory Parameters.";
					statusMessageLong = thrown.getMessage();
					break;
				case "IEMRException":
					statusCode = USERID_FAILURE;
					statusMessage = "User login failed";
					statusMessageLong = thrown.getMessage();
					break;
				case "JSONException":
					statusCode = OBJECT_FAILURE;
					statusMessage = "Invalid object conversion";
					statusMessageLong = thrown.getMessage();
					break;
				case "IllegalActionException":
					statusCode = ILLEGAL_ACTION;
					statusMessage = "Illegal Action performed. Please contact your adminstrator.";
					statusMessageLong = thrown.getMessage();
					break;

				case "SQLException":
				case "ParseException":
				case "NullPointerException":
				case "SQLGrammarException":
				case "ArrayIndexOutOfBoundsException":
				case "ConstraintViolationException":
					this.statusCode = CODE_EXCEPTION;
					statusMessage = "Failed with critical errors at " + currDate.toString()
							+ ".Please try after some time. " + "If error is still seen, contact your administrator.";
					statusMessageLong = thrown.getMessage();
					break;
				case "IOException":
				case "ConnectException":
				case "ConnectIOException":
					this.statusCode = ENVIRONMENT_EXCEPTION;
					statusMessage = "Failed with connection issues at " + currDate.toString()
							+ "Please try after some time. " + "If error is still seen,  contact your administrator.";
					statusMessageLong = thrown.getMessage();
					break;
				case "JDBCException":
					this.statusCode = ENVIRONMENT_EXCEPTION;
					statusMessage = "Failed with DB connection issues at " + currDate.toString()
							+ ". Please try after some time. " + "If error is still seen,  contact your administrator.";
					statusMessageLong = thrown.getMessage();
					break;
				default:
					statusCode = GENERIC_FAILURE;
					statusMessage = "Failed with generic exception";
					statusMessageLong = thrown.getMessage();
					break;
			}
			return this;
		}

		// private JsonElement parser(String str) throws JsonParseException, JsonSyntaxException {
		// JsonElement element = new JsonParser().parse(str);
		// return element;
		// }
		//
		// private JsonObject createJsonObject(String name, Object value) throws JsonParseException, JsonSyntaxException
		// {
		// JsonObject element = new JsonObject();
		// if(value instanceof Boolean) {
		// element.addProperty(name, (Boolean)value);
		// } else if(value instanceof Character) {
		// element.addProperty(name, (Character)value);
		// } else if(value instanceof Number) {
		// element.addProperty(name, (Number)value);
		// } else if(value instanceof String) {
		// element.addProperty(name, (String)value);
		// } else if(value instanceof JsonElement) {
		// element.add(name, (JsonElement)value);
		// }
		//
		// return element;
		// }

		/**
		 * To Do for later
		 * 
		 * @return
		 */
		// // SUNIL TODO: Add this when needed!
		// private JsonElement createJsonArray(List<Object> list, Type type) {
		// Type typeOfSrc = new TypeToken<List<FeedbackDTOOutbound>>(){private static final long serialVersionUID =
		// 1L;}.getType();
		// JsonElement element = new JsonArray();
		// return element;
		// }

		public OutputResponse build()
		{
			OutputResponse response = new OutputResponse();
			JsonObject elements = new JsonObject();
			elements.addProperty("methodName", methodName);
			elements.addProperty("dataObjectType", dataObjectType);
			elements.addProperty("dataJsonType", dataJsonType);
			elements.addProperty("data", data);
			elements.addProperty("statusCode", statusCode);
			elements.addProperty("statusMessage", statusMessage);
			elements.addProperty("statusMessageLong", statusMessageLong);

			response.setResponse(elements);

			return response;
		}
	}

	protected OutputResponse()
	{

	}

	@Override
	public String toString()
	{
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		builder.serializeNulls();
		builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
		return builder.create().toJson(this);
	}
}
