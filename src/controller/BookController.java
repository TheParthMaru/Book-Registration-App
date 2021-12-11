/*
 * Acts as mediator between dao and view
 */

package controller;

import java.util.Date;
import java.util.List;

import dao.BookDAOImpl;
import model.BookRegistration;

public class BookController {
	BookRegistration registration;
	BookDAOImpl impl = new BookDAOImpl();

	public int addBook(String bname, Double edition, Date published) {
		registration = new BookRegistration(bname, edition, published); // set the values to the member variables

		return impl.addBook(registration);
	}

	public List<BookRegistration> readBook() {
		return impl.readBook();
	}

	public int updateBook(Long bid, String bname, Double edition, Date published) {
		registration = new BookRegistration(bid, bname, edition, published); // set the values to the member variables

		return impl.updateBook(registration);
	}

	public int deleteBook(Long bid) {
		registration = new BookRegistration();
		registration.setBid(bid);
		return impl.deleteBook(registration);
	}
}
