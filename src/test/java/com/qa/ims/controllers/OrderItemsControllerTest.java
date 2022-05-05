package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemsControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderItemsDAO dao;
	
	@InjectMocks
	private OrderItemsController controller;
	
	@Test
	public void testCreate() { 
		final Long orderid = 2L, itemid = 1L, quantity = 1L;
		final OrderItems created = new OrderItems(orderid, itemid, quantity);
		
		Mockito.when(this.utils.getLong()).thenReturn(orderid, itemid, quantity);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	@Test
	public void testReadAll() {
		List<OrderItems> oi = new ArrayList<>();
		oi.add(new OrderItems(2L, 1L, 1L));
		
		Mockito.when(dao.readAll()).thenReturn(oi);
		
		assertEquals(oi, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	@Test 
	public void testReadById() {
		final long ID = 1L;
		OrderItems read = new OrderItems(ID, 2L, 1L, 1L);
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.read(ID)).thenReturn(read);
		
		assertEquals(read, this.controller.read());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).read(ID);
	}
	@Test
	public void testUpdate() {
		OrderItems updated = new OrderItems(2L, 1L, 1L, 1L);
		
		Mockito.when(this.utils.getLong()).thenReturn(2L, 1L, 1L, 1L);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
