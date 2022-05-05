package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

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
}
