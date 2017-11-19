package uade.ioo.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Util {
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(Exception e) { 
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static boolean isDouble(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch(Exception e) { 
	        return false; 
	    } 
	    // only got here if we didn't return false
	    return true;
	}

	public static boolean isDate(String s) {
		try {
			DateTime.parse(s, DateTimeFormat.forPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
