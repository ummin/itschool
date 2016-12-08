package kr.ac.itschool.custom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CustomDateFormat {
	 public static String dateFormat() {
		 Calendar calendar = new GregorianCalendar();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd aa hh:mm");
			String today = dateFormat.format(calendar.getTime());
	    return today;
	}
}