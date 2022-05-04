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

	@Override
	public List<Orders> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders create() {
		LOGGER.info("Please enter the customer id:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the item id:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the item amount:");
		Integer amount = utils.getInt();
		Orders order = orderDAO.create(new Orders(customerId, itemId, amount));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Orders update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
