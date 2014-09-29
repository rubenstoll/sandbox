package org.unitedstollutions.cookbook.reflections;

import java.lang.reflect.Field;

/**
 * Created by ruben on 22/07/14.
 */
public class FindField {

    public static void main(String[] unused)
            throws NoSuchFieldException, IllegalAccessException {

        // Create instance of FindField
        FindField gf = new FindField();

        // Create instance of target class (YearHolder defined below).
        Object o = new YearHolder();

        // Use gf to extract a field from o.
        System.out.println("The value of 'currentYear' is: " +
                gf.intFieldValue(o, "currentYear"));
    }

    int intFieldValue(Object o, String name)
            throws NoSuchFieldException, IllegalAccessException {
        Class<?> c = o.getClass();
        Field fld = c.getField(name);
        int value = fld.getInt(o);
        return value;
    }
}

