package com.maveric.transactionservicetest.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class Constants {

        public static String getCurrentDateTime() {
            Calendar cal = Calendar.getInstance();
            Date date=cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            String formattedDate=dateFormat.format(date);
            System.out.println("Current time of the day using Calendar - 24 hour format: "+ formattedDate);
            return formattedDate;
        }
    }
