package it.univaq.disim.sose.fooddetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;
import it.univaq.disim.sose.util.Utility;

public class ReviewDataClient {
	
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByFoodID";
	
	public static ReviewList getReviewData(String foodId) {
		
		WebClient client = WebClient.create(ReviewDataServiceURL + "?foodID=" + foodId);
		Utility.consoleLog("Calling: " + ReviewDataServiceURL + "?foodID=" + foodId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		String content = response.readEntity(String.class);
		Utility.consoleLog("Content: " + content);
		
		JSONArray responseArray = new JSONArray(content);
		Utility.consoleLog(responseArray.toString(2));
		
		List<Review> reviewList = new ArrayList<Review>();
		
		for (int i = 0; i < responseArray.length(); i++) {
			JSONObject reviewJSON = responseArray.getJSONObject(i);
			try {
			reviewList.add(
					new Review(
							reviewJSON.getString("foodID"), 
							reviewJSON.getInt("userID"), 
							reviewJSON.getString("title"), 
							reviewJSON.getString("comment")
							));
			}
			catch (Exception ex) {
				ex.printStackTrace();
				Utility.consoleLog("Review not added " + reviewJSON.toString());
			}
		}
		
		/**
		 * XML RESPONSE
		 * 
		 * 	XStream xstream = new XStream();
			xstream.allowTypesByWildcard(new String[] { 
			        "it.univaq.disim.sose.**"
			        });
			
			xstream.alias("Reviews", ReviewList.class);
		 */
		
		
		ReviewList responseList = new ReviewList(reviewList);
		
		// System.out.println(responseList.toString());
		return responseList;
		
	}

}
