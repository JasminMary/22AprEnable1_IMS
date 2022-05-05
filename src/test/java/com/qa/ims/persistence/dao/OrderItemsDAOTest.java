package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	@Test
	public void testReadAll() {
		List<OrderItems> expected = new ArrayList<>();
		expected.add(new OrderItems(1L, 1L, 1L));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testRead() {
		final Long ID = 1L;
		assertEquals(new OrderItems(ID, 1l, 1l,1l), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final OrderItems updated = new OrderItems(2L, 1L, 1L, 1L);
		assertEquals(updated, DAO.update(updated));
	}
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
	
