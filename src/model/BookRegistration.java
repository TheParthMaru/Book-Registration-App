/*
 * DB table name -> book_registration
 * Hence class name -> BookRegistration
 * No of tables = No of pojo classes or classes in model package
 * 
 * Generate default constructor, parameterized constructor, getters/setters and toString().
 */

package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookRegistration {
//	Table columns made data members
	private Long bid;
	private String bname;
	private Double edition;
	private Date published;

// Default constructor
	public BookRegistration() {

	}

//	Parameterized Constructor
	public BookRegistration(Long bid, String bname, Double edition, Date published) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.edition = edition;
		this.published = published;
	}

	public BookRegistration(String bname, Double edition, Date published) {
		this.bname = bname;
		this.edition = edition;
		this.published = published;
	}

//	Getters and Setters

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getEdition() {
		return edition;
	}

	public void setEdition(Double edition) {
		this.edition = edition;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

//	toString()
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return String.format("%-10s%-20s%-10s%s", bid, bname, edition, sdf.format(published));
	}

}
