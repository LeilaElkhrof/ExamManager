package DateUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
public static Date parse(String dateAsString) {
	/*SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	try {
		return parser.parse(dateAsString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return null;*/
	LocalDateTime localDateTime = LocalDateTime.parse(dateAsString);
	Timestamp timestamp = Timestamp.valueOf(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	Date date = new Date(timestamp.getTime());
	return date;
}
}
