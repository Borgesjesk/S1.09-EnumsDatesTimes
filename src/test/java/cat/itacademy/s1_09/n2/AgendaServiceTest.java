package cat.itacademy.s1_09.n2;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendaServiceTest {

    private static final LocalDateTime NOW = LocalDateTime.of(2026, 3, 27, 10, 0);

    @Test
    void getUpcoming_excludesPastAppointments() {
        List<Appointment> appointments = Arrays.asList(
                new Appointment("Past",   NOW.minusDays(1)),
                new Appointment("Future", NOW.plusDays(1))
        );
        AgendaService service = new AgendaService(appointments);

        List<Appointment> result = service.getUpcoming(NOW);

        assertEquals(1, result.size());
        assertEquals("Future", result.get(0).getTitle());
    }

    @Test
    void getUpcoming_returnsSortedByDateTime() {
        List<Appointment> appointments = Arrays.asList(
                new Appointment("Third",  NOW.plusDays(3)),
                new Appointment("First",  NOW.plusHours(2)),
                new Appointment("Second", NOW.plusDays(1))
        );
        AgendaService service = new AgendaService(appointments);

        List<Appointment> result = service.getUpcoming(NOW);

        assertEquals(3, result.size());
        assertEquals("First",  result.get(0).getTitle());
        assertEquals("Second", result.get(1).getTitle());
        assertEquals("Third",  result.get(2).getTitle());
    }

    @Test
    void getUpcoming_noFutureAppointments_returnsEmptyList() {
        List<Appointment> appointments = Arrays.asList(
                new Appointment("Past1", NOW.minusDays(2)),
                new Appointment("Past2", NOW.minusHours(1))
        );
        AgendaService service = new AgendaService(appointments);

        List<Appointment> result = service.getUpcoming(NOW);

        assertTrue(result.isEmpty());
    }
}
