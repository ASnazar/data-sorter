package org.sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    private static final String MONTH_SEPARATOR = "r";

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> datesWithoutR = new ArrayList<>();
        List<LocalDate> datesWithR = new ArrayList<>();

        for (LocalDate localDate: unsortedDates) {
            String month = localDate.getMonth().toString().toLowerCase();
            if(month.contains(MONTH_SEPARATOR)) {
                datesWithR.add(localDate);
                continue;
            }
            datesWithoutR.add(localDate);
        }

        datesWithoutR.sort(Comparator.reverseOrder());
        datesWithR.sort(Comparator.naturalOrder());

        Collection<LocalDate> sortedDates = new ArrayList<>();
        sortedDates.addAll(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }
}
