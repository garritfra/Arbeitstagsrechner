package de.ckc.ausbildung.garrit.arbeitstagsrechner.model;

import java.util.Calendar;

/**
 * Created by garritfra on 29.04.18.
 * <p>
 * This class calculates the difference between two dates
 */

public class DateInterval {

    private Calendar dateStart;
    private Calendar dateEnd;
    private int intervalInDays;

    public DateInterval(Calendar dateStart, Calendar dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.intervalInDays = calculateInterval(this.dateStart, this.dateEnd);
    }


    private int calculateInterval(Calendar dateStart, Calendar dateEnd) {
        long differenceLong = calculateDifference(dateStart, dateEnd);
        int days = calculateDays(differenceLong);
        return makeIntegerPositive(days);
    }

    private int makeIntegerPositive(int days) {
        return Math.abs(days);
    }

    private int calculateDays(long differenceLong) {
        return (int) (differenceLong / 86400000);
    }

    private long calculateDifference(Calendar dateStart, Calendar dateEnd) {
        long dateStartLong = dateStart.getTimeInMillis();
        long dateEndLong = dateEnd.getTimeInMillis();
        return dateEndLong - dateStartLong;
    }

    public int getIntervalInDays() {
        return intervalInDays;
    }

    void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
        this.intervalInDays = calculateInterval(dateStart, dateEnd);
    }

    void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
        this.intervalInDays = calculateInterval(dateStart, dateEnd);
    }
}
