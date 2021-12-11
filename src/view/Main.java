package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import dao.Query;
import model.BookRegistration;

public class Main {

	static int result;
	static String v[];
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static Date published;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookController controller = new BookController();

		try {
			sdf.setLenient(false);
			Integer option;

			do {
				System.out.println("\nChoose your option");
				System.out.println("1) Add Book 2) Retrieve 3) Update 4) Delete 5) Exit");
				System.out.print("\nOption -> ");
				option = scan.nextInt();
				scan.nextLine();
				System.out.println();

				switch (option) {

				case 1:
					System.out.println("Book Name, Edition, Published Date(yyyy-MM-dd)");
					v = scan.nextLine().split(",");

					published = sdf.parse(v[2]);

					result = controller.addBook(v[0], Double.parseDouble(v[1]), published);
					if (result > 0) {
						System.out.println("Book has been added successfully\n");
					} else {
						System.out.println("Not added successfully\n");
					}
					break;

				case 2:
					List<BookRegistration> list = controller.readBook();
					if (list.size() > 0) {
						System.out.format(Query.tabular);
						for (BookRegistration bookRegistration : list) {
							System.out.println(bookRegistration); // will invoke toString()
						}
					} else {
						System.out.println("No records found\n");
					}
					break;

				case 3:
					System.out.println("\nUpdate Record: Book Id, Book Name, Edition, Published Date(yyyy-MM-dd)");
					v = scan.nextLine().split(",");

					published = sdf.parse(v[3]);

					result = controller.updateBook(Long.parseLong(v[0]), v[1], Double.parseDouble(v[2]), published);
					if (result > 0) {
						System.out.println("Book has been updated successfully\n");
					} else {
						System.out.println("Book ID not found\n");
					}
					break;

				case 4:
					System.out.print("Enter book id: ");
					result = controller.deleteBook(scan.nextLong());

					if (result > 0) {
						System.out.println("Book has been deleted successfully\n");
					} else {
						System.out.println("Book ID not found\n");
					}
					break;

				case 5:
					System.out.println("\nThank You!");
					return;

				default:
					System.out.println("\nInvalid Option!!! Please enter a valid option\n");
				}

			} while (option != 5);
		} catch (ParseException | NumberFormatException | InputMismatchException ex) {

			System.out.println("Main " + ex.getMessage());
		}

		finally {
			scan.close();
		}
	}
}
