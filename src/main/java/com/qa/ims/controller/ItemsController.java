package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}
	@Override
	public List<Items> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item price");
		Double price = utils.getDouble();
		Items item = itemsDAO.create(new Items(itemName, price));
		LOGGER.info("Item has been created");
		return item;
	}

	@Override
	public Items update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
