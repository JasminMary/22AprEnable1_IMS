package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {
	
	private final ItemsDAO DAO = new ItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Items created = new Items(7L, "PC", 999.99d);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(5L, "jumper", 10.99d));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "lamp", 15d);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Items(4L, "bag", 20.75d), DAO.readLatest());
	}
	
	@Test
	public void read() {
		final Long id = 1L;
		assertEquals(new Items(1L, "bag", 20.75d), DAO.read(id));
		
	}
}
