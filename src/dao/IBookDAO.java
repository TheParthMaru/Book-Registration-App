/*
 * DAO stands for data access object. It consists of all the functionalities.
 * Request and response process happens here with the help of model.
 * In dao we always need interface and implementation class.
 */

package dao;

import java.util.List;

import model.BookRegistration;

public interface IBookDAO {
	public int addBook(BookRegistration registration);

	public List<BookRegistration> readBook();

	public int updateBook(BookRegistration registration);

	public int deleteBook(BookRegistration registration);

}
