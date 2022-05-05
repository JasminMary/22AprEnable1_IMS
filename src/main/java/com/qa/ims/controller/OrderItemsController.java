package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

public class OrderItemsController implements CrudController<OrderItems> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemsDAO orderitemsDAO;
	private Utils utils;
	
	public OrderItemsController(OrderItemsDAO orderitemsDAO, Utils utils) {
		super();
		this.orderitemsDAO = orderitemsDAO;
		this.utils = utils;
	}

	@Override
	public List<OrderItems> readAll() {
		List<OrderItems> oi = orderitemsDAO.readAll();
		for (OrderItems i : oi) {
			LOGGER.info(i);
		}
		return oi;
	}
	public OrderItems read() {
		LOGGER.info("Please enter the id of the order items you would like to read");
		Long id = utils.getLong();
		return orderitemsDAO.read(id);
	}

	@Override
	public OrderItems create() {
		LOGGER.info("Please enter the order id");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the item id of the item you wish to add");
		Long itemid = utils.getLong();
		LOGGER.info("Please enter the quantity of the item you wish to add");
		Long quantity = utils.getLong();
		OrderItems oi = orderitemsDAO.create(new OrderItems(orderid, itemid, quantity));
		LOGGER.info("Items added to order");
		return oi;
	}

	@Override
	public OrderItems update() {
		LOGGER.info("Please enter the id of the order_items you would like to update:");
		Long id = utils.getLong();
		LOGGER.info("Please enter order id");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter item id");
		Long itemid = utils.getLong();
		LOGGER.info("Please enter item quantity");
		Long quantity = utils.getLong();
		OrderItems oi = orderitemsDAO.update(new OrderItems(id, orderid, itemid, quantity));
		return oi;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
