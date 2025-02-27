package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;


public class OrderDAO implements Dao<Order> {

    public static final Logger LOGGER = LogManager.getLogger();


    @Override
    public List<Order> readAll() {

        try(Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                orders.add(modelFromResultSet(resultSet));
            }
            return orders;
        }catch (SQLException e){
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();      
    }

    @Override
    public Order read(Long id) {

        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");){
            statement.setLong(1,id);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);            
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO orders(customer_id, items, itemIds, order_cost) VALUES (?, ?, ?, ?)");) {
            statement.setLong(1, order.getCustomerId());
            statement.setString(2, order.getItems());
            statement.setString(3, order.getItemIds());
            statement.setDouble(4, order.getCost());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e){
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }        

        return null;      

    }

    @Override
    public Order update(Order order) {

        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orders SET items = ?, itemIds = ?, order_cost = ? WHERE id = ?");) {
                statement.setString(1, order.getItems());
                statement.setString(2, order.getItemIds());
                statement.setDouble(3, order.getCost());
                statement.setLong(4,order.getId());
                statement.executeUpdate();
                return read(order.getId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
             statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Long customerId = resultSet.getLong("customer_id");
        String items = resultSet.getString("items");
        String itemIds = resultSet.getString("itemIds");
        double order_cost = resultSet.getDouble("order_cost");
        return new Order(id, customerId, items, itemIds, order_cost);
    }


    public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
    
}
