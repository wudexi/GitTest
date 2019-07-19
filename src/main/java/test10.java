import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;


public class test10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
			int x = 24;
			String endDate = "2018-10-01 18:00";
			String startDate = "2018-09-17 10:00";
			
			Date s = sf.parse(startDate);
			Date e = sf.parse(endDate);
			
			Calendar c1 = Calendar.getInstance();
					c1.setTime(s);
			Calendar c2 = Calendar.getInstance();
					c2.setTime(e);
			
		int rt = DateUtils.getSecondBetweenDate(c1.getTime(), c2.getTime());
			System.out.println(rt);
			System.out.println(rt/3600/24);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
