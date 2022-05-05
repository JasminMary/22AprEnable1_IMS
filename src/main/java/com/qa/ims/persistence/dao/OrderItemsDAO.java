package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAO implements Dao<OrderItems>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<OrderItems> readAll() {

		return null;
	}

	@Override
	public OrderItems read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItems create(OrderItems orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(`order_id`, `item_id`, `quantity`) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderitem.getOrderId());
			statement.setLong(2, orderitem.getItemId());
			statement.setLong(3, orderitem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY order_item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItems update(OrderItems t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oiID = resultSet.getLong("order_item_id");
		Long orderid = resultSet.getLong("order_id");
		Long itemid = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrderItems(oiID, orderid, itemid, quantity);
	}

}
