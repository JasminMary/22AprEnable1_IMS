package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	@Test
	public void testCreate() {
		final Orders created = new Orders(4L, 2L);
		assertEquals(created, DAO.create(created));
	
	}
	@Test
	public void readAllTest() {
	List<Orders> expected = new ArrayList<>();
	expected.add(new Orders(1L, 1L));
	assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testRead() {
	final Long ID = 1L;
	assertEquals(new Orders(ID, 1L), DAO.read(ID));
	}
	@Test
	public void testUpdate() {
		final Orders updated = new Orders(1L, 3L);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

	}

