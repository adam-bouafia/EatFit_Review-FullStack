package it.univaq.disim.sose.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Review")
public class Review {
	
	
	private String  foodID;
	private int userID; 
	private String title;
	private String comment;
	
	public Review() {
		
	}

		
	public Review(String foodID, int userID,String title, String comment) {
		super();
		this.foodID = foodID;
		this.userID = userID;
		this.title = title;	
		this.comment = comment;
	}
	
	public Review(ResultSet resultSet) throws SQLException {
		this.foodID = resultSet.getString(1);
		this.userID = resultSet.getInt(2);
		this.title = resultSet.getString(3);
		this.comment = resultSet.getString(4);
	}

	public String getFoodID() {
		return foodID;
	}

	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Review [foodID=" + foodID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
	}
}
