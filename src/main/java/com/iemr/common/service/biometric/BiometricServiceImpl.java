package com.iemr.common.service.biometric;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

@Service
public class BiometricServiceImpl implements BiometricService {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Value("${biometric.discover.url}")
	String discoverUrl;

	@Value("${biometric.deviceInfo.url}")
	private String deviceInfoUrl;

	@Value("${biometric.capture.url}")
	private String captureUrl;
	
	@Override
	public String getBioData(String env) {
		String pidRes = null;
		try {
			String portNumber = null;
			for (int i = 11100; i <= 11120; i++) {
				String port = String.valueOf(i);
				String apiUrl = discoverUrl.replace("port", port);

				String httpMethod = "RDSERVICE";
				HttpClient httpClient = HttpClientBuilder.create().build();

				HttpRequestBase request = new HttpRequestBase() {
					@Override
					public String getMethod() {
						return httpMethod;
					}
				};
				request.setURI(URI.create(apiUrl));
				request.setHeader(HttpHeaders.CONTENT_TYPE, "TEXT/XML");
				try {
					HttpResponse response = httpClient.execute((HttpUriRequest) request);

					HttpEntity entity = response.getEntity();
					String responseString = EntityUtils.toString(entity, "UTF-8");
					if (!responseString.contains("NOTREADY")) {
						portNumber = port;
						break;
					}
				} catch (Exception e) {
					logger.error("Error while checking biometric status: " + e.getMessage());
				}
			}
			String xmlResponse = getDeviceInfo(portNumber, env);
			if(xmlResponse != null) {
				pidRes = Base64.getEncoder().encodeToString(xmlResponse.getBytes());
			}
		} catch (Exception e) {
			logger.error("Error while getting biometric data: " + e.getMessage());
		}
		return pidRes;
	}

	private String getDeviceInfo(String portNumber, String env) {
		String deviceRes = null;
		String deviceInforURL = deviceInfoUrl.replace("port", portNumber);

		String httpMethod = "DEVICEINFO";
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpRequestBase request = new HttpRequestBase() {
			@Override
			public String getMethod() {
				return httpMethod;
			}
		};
		request.setURI(URI.create(deviceInforURL));
		request.setHeader(HttpHeaders.CONTENT_TYPE, "TEXT/XML");
		try {
			HttpResponse response = httpClient.execute((HttpUriRequest) request);

			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");

			if (null != response && response.getStatusLine().getStatusCode() == 200) {
				deviceRes = getCaptureInfo(portNumber, env);
			}
		} catch (Exception e) {
			logger.error("Error while getting biometric device info : " + e.getMessage());
		}
		return deviceRes;
	}

	private String getCaptureInfo(String portNumber, String env) throws Exception {
		String captureRes = null;
		if (null != portNumber) {
			try {
				// Create a new DocumentBuilder
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

				// Create a new Document
				Document doc = docBuilder.newDocument();

				// Create the root element <PidOptions>
				Element pidOptionsElement = doc.createElement("PidOptions");
				pidOptionsElement.setAttribute("ver", "1.0");
				doc.appendChild(pidOptionsElement);

				// Create the <Opts> element and its attributes
				Element optsElement = doc.createElement("Opts");
				optsElement.setAttribute("fCount", "1");
				optsElement.setAttribute("fType", "2");
				optsElement.setAttribute("iCount", "0");
				optsElement.setAttribute("pCount", "0");
				optsElement.setAttribute("pgCount", "2");
				optsElement.setAttribute("format", "0");
				optsElement.setAttribute("pidVer", "2.0");
				optsElement.setAttribute("timeout", "10000");
				optsElement.setAttribute("pTimeout", "20000");
				optsElement.setAttribute("wadh", "E0jzJ/P8UopUHAieZn8CKqS4WPMi5ZSYXgfnlfkWjrc=");
				optsElement.setAttribute("posh", "UNKNOWN");
				optsElement.setAttribute("env", env);
				pidOptionsElement.appendChild(optsElement);

				// Create the <CustOpts> element
				Element custOptsElement = doc.createElement("CustOpts");
				pidOptionsElement.appendChild(custOptsElement);

				// Create the <Param> element inside <CustOpts> with its attributes
				Element paramElement = doc.createElement("Param");
				paramElement.setAttribute("name", "mantrakey");
				paramElement.setAttribute("value", "");
				custOptsElement.appendChild(paramElement);

				// Create a text node for indentation
				Text text = doc.createTextNode("\n");
				pidOptionsElement.insertBefore(text, optsElement);

				// Print the XML content to the console
				String xml = XMLToString(doc);
				
				String capturingURL = captureUrl.replace("port", portNumber);
				URL url = new URL(capturingURL);

				String httpMethod = "CAPTURE";
				HttpClient httpClient = HttpClients.createDefault();

				HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
					@Override
					public String getMethod() {
						return httpMethod;
					}
				};
				request.setURI(URI.create(capturingURL));
				StringEntity entity2 = new StringEntity(xml);
				request.setEntity(entity2);
				request.setHeader(HttpHeaders.CONTENT_TYPE, "TEXT/XML");
				
				HttpResponse response = httpClient.execute(request);
				response.setHeader("Content-Type", "TEXT/XML");
				InputStream entity1 = response.getEntity().getContent();
				String result = new BufferedReader(new InputStreamReader(entity1))
						   .lines().collect(Collectors.joining("\n"));
				if(result.contains("Success")) {
					captureRes = result;
				} else {
					throw new Exception("Capture timed out");
				}
				
		} catch (ParserConfigurationException e) {
			logger.error("Error while capturing fingerprint: " + e.getMessage());
		}
		}
		return captureRes;
	}

	private String XMLToString(Document doc) {
		String response = null;
		try {
			javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
			javax.xml.transform.Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
			javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(
					new java.io.StringWriter());
			javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
			transformer.transform(source, result);
			response = result.getWriter().toString();
		} catch (Exception e) {
			logger.error("Error while converting XML to String: " + e.getMessage());
		}
		return response;
	}

}
