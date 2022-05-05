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

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrdersDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long custid = 2L;
		Orders created = new Orders(custid);
	
		Mockito.when(utils.getLong()).thenReturn(created.getCustomerId());

		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(dao, Mockito.times(1)).create(created);
		Mockito.verify(utils, Mockito.times(1)).getLong();

	}
	@Test
	public void testReadALL() {
		List<Orders> order = new ArrayList<>();
		order.add(new Orders(1L));
		
		Mockito.when(dao.readAll()).thenReturn(order);
		
		assertEquals(order, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
}
