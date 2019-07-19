import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;


public class test8 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
//		String str = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
//		System.out.println(str);
//		
//		Date d = DateUtils.parseDate("2014-8-8", new String[]{"yyyy-MM-dd"});
//		System.out.println(d.toLocaleString());
//		
//		SimpleDateFormat fat = new SimpleDateFormat("yyyy-MM-dd");
//	
		int x=3,y=6,z=7;
	//	int y=0;
	
		int a=(x++)+(y+=1);
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(a);
		
		
	}

}
