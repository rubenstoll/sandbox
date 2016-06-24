package jpa.springmockito.reflections;

import java.util.Calendar;

/**
 * This is just a class that we want to get a field from
 */
class YearHolder {
    /**
     * Just a field that is used to show getting a field's value.
     */
    public int currentYear = Calendar.getInstance().get(Calendar.YEAR);
}
