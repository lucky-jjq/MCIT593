package datamanagement;

import org.json.simple.*;
import org.json.simple.parser.*;
import data.ViolationData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadJSON extends DataFile{
	protected ArrayList<ViolationData> ViolationDataList = new ArrayList<ViolationData>(); 
	
	protected boolean filterState(String state) {
		return state.toUpperCase().equals( "PA");
	}
	
	protected boolean filterZipMissing(String zipCode) {
		return !zipCode.isEmpty();
	}
	
	protected ViolationData jsonParser(JSONObject violation) {
		ViolationData vio = new ViolationData();
		if ( filterZipMissing(violation.get("zip_code").toString()) ){//filter out missing zip code
			System.out.println(violation.get("zip_code"));
			vio.date = (String) violation.get("date");
			Long fine =  (Long) violation.get("fine");
			vio.fine = Math.toIntExact( fine);
			vio.reason = (String) violation.get("violation");
			vio.plateNum = (String) violation.get("plate_id");
			Long violationID = (Long) violation.get("ticket_number");
			vio.violationID = (String) vio.violationID;
			vio.state = (String) violation.get("state");
			if (filterState(vio.state)) {
				return null; //filter out state that are not PA
			}
			vio.zipCode = (String) violation.get("zip_code");
			System.out.println(vio);
			return vio;
		}else {
			return null;
		}
		
	}
	
	
	public void readJSONFile() {		
		// create a parser
		JSONParser parser = new JSONParser();
		// open the file and get the array of JSON objects
		JSONArray violations = null;
		try {
			violations = (JSONArray)parser.parse(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// use an iterator to iterate over each element of the array
		Iterator iter = violations.iterator();
		// iterate while there are more objects in array
		while (iter.hasNext()) {
			// get the next JSON object
			JSONObject violation = (JSONObject) iter.next();
			ViolationData vio = jsonParser(violation);
			if (vio!=null) {
				ViolationDataList.add(vio);
			}
		}
	}
	
	public ArrayList<ViolationData> getViolationDataList() {
		if (ViolationDataList.isEmpty()) {
			readJSONFile();
		}
		return ViolationDataList;
	}
	
	
	public static void main(String[] args) {
		ReadJSON c = new ReadJSON();
		c.fileName = "parking.json";
		c.getViolationDataList();
	}
}
