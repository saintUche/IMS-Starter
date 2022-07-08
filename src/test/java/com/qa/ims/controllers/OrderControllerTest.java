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
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

    @Test
	public void testCreate() {
		final String items = "fork,spoon", itemIds = "1,2";
        final Long customerId = 1L;
        final double cost = 2.50;
		final Order created = new Order(customerId, items, itemIds, cost);

		Mockito.when(utils.getString()).thenReturn(items, itemIds);
		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(utils.getDouble()).thenReturn(cost);

		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();

		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

    @Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "fork", "1", 2.50));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}


    @Test
	public void testUpdate() {
		Order updated = new Order(1L, 2L, "fork", "1", 2.50);
		
        Mockito.when(this.utils.getLong()).thenReturn(1L);
        Mockito.when(this.utils.getLong()).thenReturn(2L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItems(), updated.getItemIds());
        Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
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
