package cat.itacademy.s1_09.n2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaService {

    private final List<Appointment> appointments;

    public AgendaService(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Appointment> getUpcoming(LocalDateTime from) {
        return appointments.stream()
                .filter(a -> a.getDateTime().isAfter(from))
                .sorted((a, b) -> a.getDateTime().compareTo(b.getDateTime()))
                .collect(Collectors.toList());
    }
}
