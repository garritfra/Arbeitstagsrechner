package de.ckc.ausbildung.garrit.arbeitstagsrechner.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import de.ckc.ausbildung.garrit.arbeitstagsrechner.Utils.DateParser;

/**
 * Created by garritfra on 29.04.18.
 * <p>
 * This class includes tests for the DateInterval class
 */
public class DateIntervalTest {

    private DateInterval dateInterval;
    private Calendar dateStart;
    private Calendar dateEnd;

    @Before
    public void setUp() throws Exception {
        dateStart = Calendar.getInstance();
        dateEnd = Calendar.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        dateInterval = null;
        dateStart = null;
        dateEnd = null;
    }

    @Test
    public void getIntervalInDays_oneDay() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2000");
        dateEnd = DateParser.parseStringToCalendar("02.01.2000");
        dateInterval = new DateInterval(dateStart, dateEnd);
        Assert.assertEquals(1, dateInterval.getIntervalInDays());
    }

    @Test
    public void getIntervalInDays_oneYear() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2001");
        dateEnd = DateParser.parseStringToCalendar("01.01.2002");
        dateInterval = new DateInterval(dateStart, dateEnd);
        Assert.assertEquals(365, dateInterval.getIntervalInDays());
    }

    @Test
    public void getIntervalInDays_oneNegativeYear() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2002");
        dateEnd = DateParser.parseStringToCalendar("01.01.2001");
        dateInterval = new DateInterval(dateStart, dateEnd);

        Assert.assertEquals(365, dateInterval.getIntervalInDays());
    }

    @Test
    public void setDateStart() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2000");
        dateEnd = DateParser.parseStringToCalendar("02.01.2000");
        dateInterval = new DateInterval(dateStart, dateEnd);
        Assert.assertEquals(1, dateInterval.getIntervalInDays());

        dateStart.add(Calendar.DATE, -2);
        dateInterval.setDateStart(dateStart);
        Assert.assertEquals(3, dateInterval.getIntervalInDays());
    }

    @Test
    public void setDateEnd() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2000");
        dateEnd = DateParser.parseStringToCalendar("02.01.2000");
        dateInterval = new DateInterval(dateStart, dateEnd);
        Assert.assertEquals(1, dateInterval.getIntervalInDays());

        dateEnd.add(Calendar.DATE, 2);
        dateInterval.setDateEnd(dateEnd);
        Assert.assertEquals(3, dateInterval.getIntervalInDays());
    }

    @Test
    public void isValid() throws Exception {
        dateStart = DateParser.parseStringToCalendar("01.01.2000");
        dateEnd = DateParser.parseStringToCalendar("01.01.2001");
        dateInterval = new DateInterval(dateStart, dateEnd);

        Assert.assertTrue(dateInterval.isValid());
    }

    @Test
    public void isValid_endBeforeStart() throws Exception {
        dateStart.set(2001, 1, 1, 0, 0);
        dateEnd.set(2000, 1, 1, 0, 0);
        dateInterval = new DateInterval(dateStart, dateEnd);

        Assert.assertFalse(dateInterval.isValid());
    }

}