package com.qa.ims.controller;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.utils.Utils;
import java.util.List;
import java.util.regex.Pattern;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;
    private Utils utils;
    private ItemDAO itemDAO;

    public OrderController(OrderDAO orderDAO, Utils utils, ItemDAO itemDAO) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
    this.itemDAO = itemDAO;
	}
    
    @Override
    public List<Order> readAll() {
		  List<Order> orders = orderDAO.readAll();
		  for (Order order : orders) {
			  LOGGER.info(order);
		  }
		  return orders;
    }

    
    @Override
    public Order create() {

        
    String itemids = "";
    String itemList = "";
    Double cost = 0.00;

		LOGGER.info("enter customer_ID");
		Long customerId = utils.getLong();
    
    boolean complete = false;
    while(!complete){

      LOGGER.info("Please enter the item IDs of the items you would like to purchase. Press enter to stop");
      String itemid = utils.getString();
      
      if(itemid.equals("")){
          complete = true;
      }
      else{
        Long itemIdLong = Long.parseLong(itemid);
        itemids = itemids + "," + itemid;
        Item itemName = itemDAO.read(itemIdLong);
        itemList = itemList + "," + itemName.getItemName();
        cost = cost + itemName.getCost();
      }

   }
    Order order = orderDAO.create(new Order(customerId, itemList.substring(1), itemids.substring(1), cost));
    LOGGER.info("order created");
		return order;
    }

  

    @Override
    public Order update() {
      LOGGER.info("Please enter the id of the order you would like to update");
      Long id = utils.getLong();

      Order order = orderDAO.read(id);

      LOGGER.info("ADD OR DELETE ITEM FROM ORDER");
      String choice = utils.getString();
      
      if(choice.equals("DELETE")){
            LOGGER.info("Enter the Id of item you would like to remove");
            Long removeId = utils.getLong();
            String removeIdstring = Long.toString(removeId);
            String itemString = itemDAO.read(removeId).getItemName();
            double itemCost = itemDAO.read(removeId).getCost();
            String itemIds = order.getItemIds().replaceFirst(Pattern.quote(removeIdstring), "").replaceAll(",,",",");
            //System.out.println(itemIds);
            String items = order.getItems().replaceFirst(Pattern.quote(itemString), "").replaceAll(",,",",");
            //System.out.println(items);
            double cost = order.getCost() - itemCost;
            System.out.println(cost);
            Long customerId = order.getCustomerId();
            Order newOrderDel = orderDAO.update(new Order(id, customerId, items, itemIds, cost));
            return newOrderDel;
      }

      else if(choice.equals("ADD")){
            LOGGER.info("Enter the Id of item you would like to add");
            Long addId = utils.getLong();
            String addIdstring = Long.toString(addId);
            String addItemString = itemDAO.read(addId).getItemName();
            double addItemCost = itemDAO.read(addId).getCost();
            String addItemIds = order.getItemIds() + "," + addIdstring;
            String addItems = order.getItems() + "," + addItemString;
            double addCost = order.getCost() + addItemCost;
            Long addCustomerId = order.getCustomerId();
            Order newOrderAdd = orderDAO.update(new Order(id, addCustomerId, addItems.replaceAll(",,",","), addItemIds.replaceAll(",,",","),  addCost));
            return newOrderAdd;
      }
      else{
        System.out.println("Wrong input");
        return null;
      }

      }

    @Override
    public int delete() {
      LOGGER.info("Please enter the id of the order you would like to delete");
      Long id = utils.getLong();
      return orderDAO.delete(id);
    }

    

    
    
}