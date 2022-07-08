package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
    
    private final ItemDAO DAO = new ItemDAO();


    @Before
    public void setup(){
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate(){

        String itemName = "speaker";
        double itemCost = 2.50;
        final Item created = new Item(2L, itemName, itemCost);
        assertEquals(created, DAO.create(created));
    }


    @Test
    public void testReadAll() {
        String itemName = "speaker";
        double itemCost = 2.50;

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, itemName, itemCost));
        assertEquals(expected, DAO.readAll());
    }

    @Test
	public void testReadLatest() {
        String itemName = "speaker";
        double itemCost = 2.50;

		assertEquals(new Item(1L, itemName, itemCost), DAO.readLatest());
	}

    @Test
	public void testRead() {
        String itemName = "speaker";
        double itemCost = 2.50;
		final long ID = 1L;
		assertEquals(new Item(ID, itemName, itemCost), DAO.read(ID));
	}

    @Test
	public void testUpdate() {
        String itemName = "speaker";
        double itemCost = 2.50;
		final Item updated = new Item(1L, itemName, itemCost);
		assertEquals(updated, DAO.update(updated));
	}

    @Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

    
}

