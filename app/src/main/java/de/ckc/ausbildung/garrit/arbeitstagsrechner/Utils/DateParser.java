package de.ckc.ausbildung.garrit.arbeitstagsrechner.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by garritfra on 02.05.18.
 * <p>
 * Helper class to parse dates
 */

public class DateParser {
    public static Calendar parseStringToCalendar(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(Constants.datePattern, Locale.GERMAN);
        format.setLenient(false);

        Date date = format.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
    }
}
