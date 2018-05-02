package de.ckc.ausbildung.garrit.arbeitstagsrechner.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import de.ckc.ausbildung.garrit.arbeitstagsrechner.Utils.DateParser;

/**
 * Created by garritfra on 02.05.18.
 * <p>
 * Tests for the DateParser class
 */
public class DateParserTest {
    private String dateString;
    private Calendar testCal;
    private Calendar cal;


    @Before
    public void setUp() {
        testCal = Calendar.getInstance();
    }

    @After
    public void tearDown() {
        dateString = null;
        testCal = null;
    }

    @Test
    public void parseStringToCalendar() throws Exception {
        dateString = "02.05.2018";

        cal = DateParser.parseStringToCalendar(dateString);

        testCal.set(Calendar.DATE, 2);
        testCal.set(Calendar.MONTH, Calendar.MAY);
        testCal.set(Calendar.YEAR, 2018);

        Assert.assertEquals(testCal.get(Calendar.DATE), cal.get(Calendar.DATE));
        Assert.assertEquals(testCal.get(Calendar.MONTH), cal.get(Calendar.MONTH));
        Assert.assertEquals(testCal.get(Calendar.YEAR), cal.get(Calendar.YEAR));
    }

    @Test
    public void parseStringToCalendar_dateNotLenient() throws Exception {
        cal = DateParser.parseStringToCalendar("32.13.2018");
        Assert.assertNull(cal);
    }

}