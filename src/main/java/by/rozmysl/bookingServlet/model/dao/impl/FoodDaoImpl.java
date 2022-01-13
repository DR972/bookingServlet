package by.rozmysl.bookingServlet.model.dao.impl;

import by.rozmysl.bookingServlet.model.dao.FoodDao;
import by.rozmysl.bookingServlet.model.entity.hotel.Food;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.rozmysl.bookingServlet.model.dao.ColumnName.*;

/**
 * Provides the base model implementation for `FOOD` table DAO.
 */
public class FoodDaoImpl extends DaoImpl<Food, String> implements FoodDao {

    /**
     * Create Food entity
     *
     * @param resultSet ResultSet
     * @return Food object
     * @throws SQLException if there was an error accessing the database
     */
    @Override
    public Food buildEntity(ResultSet resultSet) throws SQLException {
        return new Food(
                resultSet.getString(FOOD_COLUMN_TYPE),
                resultSet.getBigDecimal(FOOD_COLUMN_PRICE));
    }
}