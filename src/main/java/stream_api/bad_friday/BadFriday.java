package stream_api.bad_friday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BadFriday {

    public void printBlackFridays(int startYear, int endYear) {
        //validate

        //iterate
        LocalDate start = LocalDate.of(startYear, 1, 1);
        LocalDate end = LocalDate.of(endYear, 12, 31);

        Map<Integer, Long> yearToBlackFridaysCount =
                Stream.iterate(start, curDate -> !curDate.isAfter(end), curDate -> curDate.plusDays(1))
                        .parallel() //does it needed?
                        .filter(curDate -> curDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                        .filter(curDate -> curDate.getDayOfMonth() == 13)
                        .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()));

        yearToBlackFridaysCount.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).reversed())
                .forEachOrdered(System.out::println); //needed or not?
    }
}
