package com.shipfast;

import com.shipfast.model.OrderRequest;
import com.shipfast.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Api {
	@Autowired
	private Services services;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/place_order", method = RequestMethod.POST)
	public @ResponseBody
	OrderStatus placeOrder(@RequestBody OrderRequest data) {
		Map<String, Object> order = new HashMap<>();
		order.put("itemId", data.getId());
		order.put("quantity", data.getQuantity());

		return restTemplate.postForObject(
			services.getURI("orders") + "/",
			order,
			OrderStatus.class
		);
	}

	@RequestMapping(value = "/check_status/{id}")
	public @ResponseBody OrderStatus checkStatus(@PathVariable("id") String id) {
		return restTemplate.getForObject(
			services.getURI("orders") + "/" + id,
			OrderStatus.class
		);
	}
}
