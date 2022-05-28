package ie.app.api;

import android.util.Log;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ie.app.models.Donation;

public class DonationApi {

	public static List<Donation> getAll(String call) {
		String json = Rest.get(call);
		Log.v("Donate", "JSON RESULT : " + json);
		Type collectionType = new TypeToken<List<Donation>>(){}.getType();

		return new Gson().fromJson(json, collectionType);
	}

	public static Donation get(String call,String id) {
		String json = Rest.get(call + "/" + id);
		Log.v("Donate", "JSON RESULT : " + json);
		Type objType = new TypeToken<Donation>(){}.getType();

		return new Gson().fromJson(json, objType);
	}

	public static String delete(String call, String id) {
		return Rest.delete(call + "/" + id);
	}

	public static String insert(String call,Donation donation) {		
		Type objType = new TypeToken<Donation>(){}.getType();
		String json = new Gson().toJson(donation, objType);
  
		return Rest.post(call,json);
	}
}
