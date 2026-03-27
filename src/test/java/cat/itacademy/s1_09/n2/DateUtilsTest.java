package cat.itacademy.s1_09.n2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void isBeforeToday_pastDate_returnsTrue() {
        LocalDate past = LocalDate.of(2020, 1, 1);
        assertTrue(DateUtils.isBeforeToday(past));
    }

    @Test
    void isBeforeToday_futureDate_returnsFalse() {
        LocalDate future = LocalDate.of(2099, 12, 31);
        assertFalse(DateUtils.isBeforeToday(future));
    }

    @Test
    void formatDate_ddMMyyyy_returnsExpectedString() {
        LocalDate date = LocalDate.of(2026, 3, 27);
        assertEquals("27/03/2026", DateUtils.formatDate(date, "dd/MM/yyyy"));
    }

    @Test
    void addDays_positiveAmount_returnsCorrectDate() {
        LocalDate date = LocalDate.of(2026, 3, 27);
        assertEquals(LocalDate.of(2026, 4, 6), DateUtils.addDays(date, 10));
    }
}
