package repn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

	public static String format(Calendar date){
		return dateFormat.format(date);
	}
	
}
