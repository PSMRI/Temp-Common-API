package com.iemr.common.controller.carestream;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.common.controller.carestream.CareStreamCreateOrderController;
import com.iemr.common.data.carestream.CreateOrderData;
import com.iemr.common.utils.mapper.InputMapper;
import com.iemr.common.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
public class CareStreamCreateOrderControllerTest {

	@Mock
	private InputMapper inputMapper;

	@InjectMocks
	private CareStreamCreateOrderController careStreamCreateOrderController;

	@Test
	void createOrderTest() throws UnknownHostException, IOException {
		String createOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(createOrder, CreateOrderData.class);

		String response = careStreamCreateOrderController.createOrder(createOrder);

		assertTrue(response.contains("Failed with Cannot assign"));
	}

	@Test
	void updateOrderTest() throws UnknownHostException, IOException {
		String updateOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(updateOrder, CreateOrderData.class);

		String response = careStreamCreateOrderController.updateOrder(updateOrder);

		assertTrue(response.contains("Connection timed out"));
	}

	@Test
	void deleteOrderTest() throws UnknownHostException, IOException {
		String deleteOrder = "{\n" + "  \"firstName\": \"John\",\n" + "  \"middleName\": \"Doe\",\n"
				+ "  \"LastName\": \"Smith\",\n" + "  \"gender\": \"Male\",\n" + "  \"dob\": \"1980-01-01\",\n"
				+ "  \"patientID\": \"123456789\",\n" + "  \"acc\": \"ACC1234\"\n" + "}";

		CreateOrderData benificiaryDetails = InputMapper.gson().fromJson(deleteOrder, CreateOrderData.class);

		String response = careStreamCreateOrderController.deleteOrder(deleteOrder);
		assertTrue(response.contains("Failed with connection issues"));

	}
}