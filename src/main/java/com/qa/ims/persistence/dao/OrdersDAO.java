package com.qa.ims.persistence.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Orders> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(`Customer_id`, `item_id`, `amount`, `total_price`) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, order.getCustomerId());
			statement.setLong(2, order.getItemId());
			statement.setInt(3, order.getAmount());
			statement.setDouble(4, 0.0);
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	private Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Integer amount = resultSet.getInt("amount");
		Double totalPrice = resultSet.getDouble("total_Price");
		String custName = resultSet.getString("first_name");
		String itemName = resultSet.getString("item_name");
		return new Orders(orderId, itemId, amount, totalPrice, custName, itemName);
	}
	


}
