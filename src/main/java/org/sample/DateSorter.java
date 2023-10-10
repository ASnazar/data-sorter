package org.sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class DateSorter {
    private static final String R_MONTH_INDICATOR = "r";

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> datesWithoutR = new ArrayList<>();
        List<LocalDate> datesWithR = new ArrayList<>();

        separateDatesByR(unsortedDates, datesWithR, datesWithoutR);

        datesWithoutR.sort(Comparator.reverseOrder());
        datesWithR.sort(Comparator.naturalOrder());

        return combineSortedDates(datesWithR, datesWithoutR);
    }

    private void separateDatesByR(List<LocalDate> unsortedDates, List<LocalDate> datesWithR, List<LocalDate> datesWithoutR) {
        for (LocalDate localDate : unsortedDates) {
            String month = localDate.getMonth().toString().toLowerCase();
            if (month.contains(R_MONTH_INDICATOR)) {
                datesWithR.add(localDate);
            } else {
                datesWithoutR.add(localDate);
            }
        }
    }

    private Collection<LocalDate> combineSortedDates(List<LocalDate> datesWithR, List<LocalDate> datesWithoutR) {
        Collection<LocalDate> sortedDates = new ArrayList<>(datesWithR);
        sortedDates.addAll(datesWithoutR);
        return sortedDates;
    }
}
