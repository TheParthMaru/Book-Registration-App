package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BookRegistration;
import util.Db;

public class BookDAOImpl implements IBookDAO {

	int result;
	PreparedStatement pst;

	@Override
	public int addBook(BookRegistration registration) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.addBook);
//			pst.setLong(1, registration.getBid());
			pst.setString(1, registration.getBname());
			pst.setDouble(2, registration.getEdition());
			pst.setDate(3, new Date(registration.getPublished().getTime()));

			result = pst.executeUpdate(); // insert command
		} catch (SQLException e) {
			System.err.println("addBook() " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<BookRegistration> readBook() {
		List<BookRegistration> list = new ArrayList<BookRegistration>();

		try {
			pst = Db.getDbProperties().prepareStatement(Query.readData);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) { // reads 1 by 1 data from database
				BookRegistration registration = new BookRegistration(rs.getLong(1), rs.getString(2), rs.getDouble(3),
						rs.getDate(4));
				list.add(registration); // list of objects
			}

		} catch (SQLException e) {
			System.err.println("readBook() " + e.getMessage());
		}
		return list;
	}

	@Override
	public int updateBook(BookRegistration registration) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.updateBook);
			pst.setString(1, registration.getBname());
			pst.setDouble(2, registration.getEdition());
			pst.setDate(3, new Date(registration.getPublished().getTime()));
			pst.setLong(4, registration.getBid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateBook() " + e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteBook(BookRegistration registration) {
		try {
			pst = Db.getDbProperties().prepareStatement(Query.deleteBook);
			pst.setLong(1, registration.getBid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("deleteBook() " + e.getMessage());
		}
		return result;
	}

}
