package by.rozmysl.bookingServlet.action.user;

import by.rozmysl.bookingServlet.action.Action;
import by.rozmysl.bookingServlet.dao.DaoFactory;
import by.rozmysl.bookingServlet.dao.user.BookingDao;
import by.rozmysl.bookingServlet.db.ConnectionSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Provides service to initialize actions on the UserBookings.
 */
public class UserBookings implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBookings.class);

    /**
     * Executes actions on request content.
     *
     * @param req request content
     * @return page to go
     * @throws SQLException if there was an error accessing the database
     */
    @Override
    public String execute(HttpServletRequest req) throws SQLException, IOException {
        BookingDao bookingDao = DaoFactory.getInstance().bookingDao(new ConnectionSource());
        if (req.getParameter("delete") != null && req.getParameter("delete").equals("delete")) {
            bookingDao.delete(Long.parseLong(req.getParameter("bookingId")));
            LOGGER.info("Booking # " + req.getParameter("bookingId") + " was canceled by the user.");
        }
        req.setAttribute("booking", bookingDao.findAllByUser(req.getUserPrincipal().getName()));
        return String.format("forward:%s", "/WEB-INF/views/user/userBookings.jsp");
    }
}
