package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrdersDAO orderDAO;
	private Utils utils;
	

	public OrderController(OrdersDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	public Orders read() {
		LOGGER.info("Please enter the id of the customer you would like to read");
		Long id = utils.getLong();
		return orderDAO.read(id);
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> order = orderDAO.readAll();
		for (Orders orders : order) {
			LOGGER.info(order);
		}
		return order;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter the customer id:");
		Long customerId = utils.getLong();
		Orders order = orderDAO.create(new Orders(customerId));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the customer id you'd like to change");
		Long custid = utils.getLong();
		Orders order = orderDAO.update(new Orders(id, custid));
		LOGGER.info("Order updated");
		return order;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
