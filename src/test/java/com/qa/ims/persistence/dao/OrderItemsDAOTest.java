package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAOTest {
	
	private final OrderItemsDAO DAO = new OrderItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	@Test
	public void testCreate() {
		final OrderItems created = new OrderItems(1L, 1L, 1L);
		assertEquals(created, DAO.create(created));
		
	}
}
	
