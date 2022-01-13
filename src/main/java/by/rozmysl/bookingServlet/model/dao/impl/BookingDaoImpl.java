package by.rozmysl.bookingServlet.model.dao.impl;

import by.rozmysl.bookingServlet.model.dao.BookingDao;
import by.rozmysl.bookingServlet.model.entity.hotel.AdditionalServices;
import by.rozmysl.bookingServlet.model.entity.hotel.Food;
import by.rozmysl.bookingServlet.model.entity.hotel.Room;
import by.rozmysl.bookingServlet.model.entity.user.Booking;
import by.rozmysl.bookingServlet.model.entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static by.rozmysl.bookingServlet.model.dao.ColumnName.*;

/**
 * Provides the base model implementation for `BOOKING` table DAO.
 */
public class BookingDaoImpl extends DaoImpl<Booking, Long> implements BookingDao {

    /**
     * Create Booking entity
     *
     * @param resultSet ResultSet
     * @return Booking object
     * @throws SQLException if there was an error accessing the database
     */
    @Override
    public Booking buildEntity(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getLong(BOOKING_COLUMN_NUMBER),
                new User(resultSet.getString(BOOKING_COLUMN_USER)),
                new Room(resultSet.getInt(BOOKING_COLUMN_ROOM), resultSet.getString(ROOM_COLUMN_TYPE), resultSet.getInt(ROOM_COLUMN_SLEEPS)),
                resultSet.getInt(BOOKING_COLUMN_PERSONS),
                LocalDate.parse(resultSet.getString(BOOKING_COLUMN_ARRIVAL)),
                LocalDate.parse(resultSet.getString(BOOKING_COLUMN_DEPARTURE)),
                resultSet.getInt(BOOKING_COLUMN_DAYS),
                new Food(resultSet.getString(BOOKING_COLUMN_FOOD)),
                new AdditionalServices(resultSet.getString(BOOKING_COLUMN_SERVICES)),
                resultSet.getBigDecimal(BOOKING_COLUMN_AMOUNT),
                resultSet.getString(BOOKING_COLUMN_STATUS));
    }
}
