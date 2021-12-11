package dao;

public class Query {

	public static String addBook = "insert into book_registration values(seq_2.nextval,?,?,?)";
	public static String readData = "select * from book_registration";
	public static String updateBook = "update book_registration set bname=?, edition=?, published=? where bid=?";
	public static String deleteBook = "delete from book_registration where bid=?";

//	Printing Statement
	public static String tabular = String.format("%-10s%-20s%-10s%s\n", "Book ID", "Book Name", "Edition",
			"Published Date");

}
