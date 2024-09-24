package Labs.Lab1.exercise3;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class Time {
    public static void main(String[] args) {
        Duration time1 = Duration.ofDays(7);
        System.out.println("First amount of time: " + time1);

        Duration time2 = Duration.ofHours(8);
        System.out.println("Duration2: " + time2);

        Duration time3 = Duration.ofMinutes(15);
        System.out.println("Duration3: " + time3);

        Duration time4 = Duration.ofSeconds(10);
        System.out.println("Duration4: " + time4);

        Duration time5 = Duration.ofSeconds(30, 123456789);
        System.out.println("Duration5: " + time5);

        Duration time6 = Duration.parse("P1DT8H15M10.345000S");
        System.out.println("Duration6: " + time6);

        Duration time7 = Duration.between(LocalDateTime.of(2019, 1, 1, 0, 0), LocalDateTime.now());
        System.out.println("Duration7: " + time7);



        Duration duration = Duration.parse("P1DT8H15M10.345000S");
        System.out.println("Duration  : " + duration);
        System.out.println("Seconds   : " + duration.getSeconds());
        System.out.println("Nano      : " + duration.getNano());

        System.out.println("NANOS     : " + duration.get(ChronoUnit.NANOS));
        System.out.println("SECONDS   : " + duration.get(ChronoUnit.SECONDS));

        System.out.println("\n#getUnits():");
        List<TemporalUnit> units = duration.getUnits();
        for (TemporalUnit unit : units) {
            System.out.println("- " + unit);
        }


        Duration time = Duration.parse("P3DT12H45M30.345000S");
        System.out.println("Duration   : " + time);
        System.out.println("Days       : " + time.toDays());
        System.out.println("Hours      : " + time.toHours());
        System.out.println("Minutes    : " + time.toMinutes());
        System.out.println("Millis     : " + time.toMillis());
        System.out.println("Nanos      : " + time.toNanos());

        System.out.println("DaysPart   : " + time.toDaysPart());
        System.out.println("HoursPart  : " + time.toHoursPart());
        System.out.println("MillisPart : " + time.toMillisPart());
        System.out.println("MinutesPart: " + time.toMinutesPart());
        System.out.println("Seconds    : " + time.toSeconds());
        System.out.println("SecondsPart: " + time.toSecondsPart());
        System.out.println("NanosPart  : " + time.toNanosPart());

        Duration duration1 = Duration.parse("P1DT8H15M10.345000S");
        System.out.println("Duration1  : " + duration1);
        System.out.println("#isNegative: " + duration1.isNegative());
        System.out.println("#isZero    : " + duration1.isZero());

        Instant instant1 = Instant.now();
        Duration duration2 = Duration.between(instant1, instant1);
        System.out.println("\nDuration2  : " + duration2);
        System.out.println("#isNegative: " + duration2.isNegative());
        System.out.println("#isZero    : " + duration2.isZero());

        Instant instant2 = Instant.now();
        Duration duration3 = Duration.between(instant2, instant1);
        System.out.println("\nDuration3  : " + duration3);
        System.out.println("#isNegative: " + duration3.isNegative());
        System.out.println("#isZero    : " + duration3.isZero());


        Duration period = Duration.parse("P1DT8H15M10.345000S");
        System.out.println("Duration            : " + period);

        // Adding/subtracting days
        System.out.println("10 days before      : " + period.minusDays(10));
        System.out.println("15 days later       : " + period.plusDays(15));

        // Adding/subtracting hours
        System.out.println("12 hours before     : " + period.minusHours(12));
        System.out.println("6 hours later       : " + period.plusHours(6));

        // Adding/subtracting minutes
        System.out.println("Minus 40 minutes    : " + period.minusMinutes(40));
        System.out.println("Plus 15 minutes     : " + period.plusMinutes(15));

        // Adding/subtracting seconds
        System.out.println("Minus 30 seconds    : " + period.minusSeconds(30));
        System.out.println("Plus 20 seconds     : " + period.plusSeconds(20));

        // Adding/subtracting Nanos
        System.out.println("Minus 3000 millis   : " + period.minusMillis(3000));
        System.out.println("Plus 5000 nanos     : " + period.plusMillis(5000));

        // Adding/subtracting Nanos
        System.out.println("Minus 20000 nanos   : " + period.minusNanos(20000));
        System.out.println("Plus 340000 nanos   : " + period.plusNanos(340000));

        // Using DAYS
        System.out.println("30 days before      : " + period.minus(30, ChronoUnit.DAYS));
        // Using HOURS
        System.out.println("8 hours before      : " + period.minus(8, ChronoUnit.HOURS));
        // Using MINUTES
        System.out.println("35 minutes before   : " + period.minus(35, ChronoUnit.MINUTES));
        // Using SECONDS
        System.out.println("125 seconds later   : " + period.plus(125, ChronoUnit.SECONDS));
        // Using MILLIS
        System.out.println("7500 millis later   : " + period.plus(7500, ChronoUnit.MILLIS));
        // Using NANOS
        System.out.println("42357500 nanos later: " + period.plus(42357500, ChronoUnit.NANOS));

        System.out.println("160 minutes before  : " + period.minus(Duration.ofMinutes(160)));
        System.out.println("3 hours later       : " + period.plus(Duration.ofHours(3)));
    }
}