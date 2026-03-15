package cat.itacademy.s1_09.n2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Ex5 - Check if date is before today
    public static boolean isBeforeToday(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    public static void main(String[] args) {

        // Ex1 - Current date, time and datetime
        System.out.println("─".repeat(40));
        System.out.println("Ex1 - Current date, time and datetime:");
        System.out.println("LocalDate:     " + LocalDate.now());
        System.out.println("LocalTime:     " + LocalTime.now());
        System.out.println("LocalDateTime: " + LocalDateTime.now());

        // Ex2 - Difference between two dates
        System.out.println("─".repeat(40));
        System.out.println("Ex2 - Difference between two dates:");
        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2026, 3, 15);
        Period period = Period.between(date1, date2);
        System.out.println("From " + date1 + " to " + date2 + ":");
        System.out.println("  " + period.getYears() + " years, "
                + period.getMonths() + " months, "
                + period.getDays() + " days");

        LocalDateTime dt1 = LocalDateTime.of(2026, 3, 15, 8, 0);
        LocalDateTime dt2 = LocalDateTime.of(2026, 3, 15, 17, 30);
        Duration duration = Duration.between(dt1, dt2);
        System.out.println("Duration between " + dt1 + " and " + dt2 + ":");
        System.out.println("  " + duration.toHours() + " hours, "
                + (duration.toMinutes() % 60) + " minutes");

        // Ex3 - Add and subtract from dates
        System.out.println("─".repeat(40));
        System.out.println("Ex3 - Add and subtract from dates:");
        LocalDate today = LocalDate.now();
        System.out.println("Today:              " + today);
        System.out.println("+ 10 days:          " + today.plusDays(10));
        System.out.println("- 3 months:         " + today.minusMonths(3));
        System.out.println("+ 1 year:           " + today.plusYears(1));
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now:                " + now);
        System.out.println("+ 5 hours:          " + now.plusHours(5));
        System.out.println("- 30 minutes:       " + now.minusMinutes(30));

        // Ex4 - Format dates
        System.out.println("─".repeat(40));
        System.out.println("Ex4 - Format dates:");
        LocalDate formatDate = LocalDate.now();
        System.out.println("Default:            " + formatDate);
        System.out.println("dd/MM/yyyy:         " + formatDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("dd-MM-yyyy:         " + formatDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("MMMM dd, yyyy:      " + formatDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        System.out.println("EEE, MMM dd yyyy:   " + formatDate.format(DateTimeFormatter.ofPattern("EEE, MMM dd yyyy")));

        // Ex5 - Is date before today
        System.out.println("─".repeat(40));
        System.out.println("Ex5 - Is date before today:");
        LocalDate past = LocalDate.of(2020, 6, 15);
        LocalDate future = LocalDate.of(2030, 1, 1);
        System.out.println(past + " is before today: " + isBeforeToday(past));
        System.out.println(future + " is before today: " + isBeforeToday(future));

        // Ex6 - Agenda with upcoming appointments
        System.out.println("─".repeat(40));
        System.out.println("Ex6 - Agenda — upcoming appointments:");
        LocalDateTime nowDt = LocalDateTime.now();
        List<Appointment> agenda = Arrays.asList(
                new Appointment("Doctor",         nowDt.plusHours(2)),
                new Appointment("Team meeting",   nowDt.plusDays(1)),
                new Appointment("Dentist",        nowDt.minusDays(1)),
                new Appointment("Java class",     nowDt.plusDays(2)),
                new Appointment("Old appointment",nowDt.minusWeeks(1))
        );

        List<Appointment> upcoming = agenda.stream()
                .filter(a -> a.getDateTime().isAfter(nowDt))
                .sorted((a, b) -> a.getDateTime().compareTo(b.getDateTime()))
                .collect(Collectors.toList());

        System.out.println("Upcoming appointments:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Appointment appointment : upcoming) {
            System.out.println("  - " + appointment.getTitle()
                    + " → " + appointment.getDateTime().format(formatter));
        }
    }
}