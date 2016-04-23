package com.memorylayers.ml.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */
public class DateTimeHelper {

    public static String convertDateToString(Date date, SimpleDateFormat simpledateformat){

        try {

            String datetime = simpledateformat.format(date);
            return datetime;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
