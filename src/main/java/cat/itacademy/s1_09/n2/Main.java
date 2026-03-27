package cat.itacademy.s1_09.n2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Main {

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
        System.out.println("+ 10 days:          " + DateUtils.addDays(today, 10));
        System.out.println("- 3 months:         " + DateUtils.subtractMonths(today, 3));
        System.out.println("+ 1 year:           " + DateUtils.addYears(today, 1));
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now:                " + now);
        System.out.println("+ 5 hours:          " + DateUtils.addHours(now, 5));
        System.out.println("- 30 minutes:       " + DateUtils.subtractMinutes(now, 30));

        // Ex4 - Format dates
        System.out.println("─".repeat(40));
        System.out.println("Ex4 - Format dates:");
        LocalDate formatDate = LocalDate.now();
        System.out.println("Default:            " + formatDate);
        System.out.println("dd/MM/yyyy:         " + DateUtils.formatDate(formatDate, "dd/MM/yyyy"));
        System.out.println("dd-MM-yyyy:         " + DateUtils.formatDate(formatDate, "dd-MM-yyyy"));
        System.out.println("MMMM dd, yyyy:      " + DateUtils.formatDate(formatDate, "MMMM dd, yyyy"));
        System.out.println("EEE, MMM dd yyyy:   " + DateUtils.formatDate(formatDate, "EEE, MMM dd yyyy"));

        // Ex5 - Is date before today
        System.out.println("─".repeat(40));
        System.out.println("Ex5 - Is date before today:");
        LocalDate past = LocalDate.of(2020, 6, 15);
        LocalDate future = LocalDate.of(2030, 1, 1);
        System.out.println(past + " is before today: " + DateUtils.isBeforeToday(past));
        System.out.println(future + " is before today: " + DateUtils.isBeforeToday(future));

        // Ex6 - Agenda with upcoming appointments
        System.out.println("─".repeat(40));
        System.out.println("Ex6 - Agenda — upcoming appointments:");
        LocalDateTime nowDt = LocalDateTime.now();
        List<Appointment> agenda = Arrays.asList(
                new Appointment("Doctor",          nowDt.plusHours(2)),
                new Appointment("Team meeting",    nowDt.plusDays(1)),
                new Appointment("Dentist",         nowDt.minusDays(1)),
                new Appointment("Java class",      nowDt.plusDays(2)),
                new Appointment("Old appointment", nowDt.minusWeeks(1))
        );

        AgendaService agendaService = new AgendaService(agenda);
        List<Appointment> upcoming = agendaService.getUpcoming(nowDt);

        System.out.println("Upcoming appointments:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Appointment appointment : upcoming) {
            System.out.println("  - " + appointment.getTitle()
                    + " → " + appointment.getDateTime().format(formatter));
        }
    }
}
