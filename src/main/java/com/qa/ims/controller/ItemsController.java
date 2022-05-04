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
		List<Items> items = itemsDAO.readAll();
		for(Items item : items);
			LOGGER.info(items);
		return items;
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
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item name");
		String iname = utils.getString();
		LOGGER.info("Please enter item price");
		Double iprice = utils.getDouble();
		Items item = itemsDAO.update(new Items(id, iname, iprice));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		int gone = itemsDAO.delete(id);
		LOGGER.info("Item deleted");
		return gone;
	}
	
	public Items read() {
		LOGGER.info("Please enter the id of the item you would like to read");
		Long id = utils.getLong();
		return itemsDAO.read(id);
	}
}
