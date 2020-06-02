package DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
public static Date parse(String dateAsString) {
	SimpleDateFormat parser=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
	try {
		return parser.parse(dateAsString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return null;
}
}
