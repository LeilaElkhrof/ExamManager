package com.fstg.gestion.exams.model.service.util;

import java.util.Date;

public class DateUtil {

		public static boolean debloquer(Date date) {
			Date currentDate = new Date();
			long diff =  currentDate.getTime()- date.getTime();
            Long diffMinutes = diff/(60*1000)%60;
			
            return diffMinutes > 15? true: false;
			}
	

}
