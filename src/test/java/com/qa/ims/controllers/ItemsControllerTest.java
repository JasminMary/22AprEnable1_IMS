package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO dao;

	@InjectMocks
	private ItemsController controller;
	
	@Test
	public void testCreate() {
		final String iname = "bottle";
		final Double iprice = 5.99d;
		final Items created = new Items(iname, iprice);
		
		Mockito.when(utils.getString()).thenReturn(iname);
		Mockito.when(utils.getDouble()).thenReturn(iprice);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
}
