# N2 - Dates and Times 📅

Working with the java.time API for robust date and time handling:
displaying, calculating differences, arithmetic, formatting,
comparing dates and building a simple agenda.

---

## ✨ Exercises
- **Ex1:** Display current `LocalDate`, `LocalTime` and `LocalDateTime`
- **Ex2:** Calculate difference between two dates using `Period` (years/months/days) and `Duration` (hours/minutes)
- **Ex3:** Add and subtract days, months, years and hours via `DateUtils` utility class
- **Ex4:** Format dates with `DateTimeFormatter` using patterns: `dd/MM/yyyy`, `dd-MM-yyyy`, `MMMM dd yyyy`, `EEE MMM dd yyyy`
- **Ex5:** `isBeforeToday()` — compares a date to `LocalDate.now()`
- **Ex6:** Agenda of `Appointment` objects filtered to show only upcoming events, sorted chronologically via `AgendaService`

---

## 🚀 How to run
```bash
mvn compile exec:java -Dexec.mainClass="cat.itacademy.s1_09.n2.Main"
```

---

## 🧪 Tests

| Test | Covers |
| :--- | :--- |
| `isBeforeToday_pastDate_returnsTrue` | Past date returns true |
| `isBeforeToday_futureDate_returnsFalse` | Future date returns false |
| `formatDate_ddMMyyyy_returnsExpectedString` | Correct format output |
| `addDays_positiveAmount_returnsCorrectDate` | Date arithmetic |
| `getUpcoming_excludesPastAppointments` | Filters past appointments |
| `getUpcoming_returnsSortedByDateTime` | Correct chronological order |
| `getUpcoming_noFutureAppointments_returnsEmptyList` | Empty agenda case |
```bash
mvn test
```

---

## 🛠 Technologies
- Java 21
- LocalDate, LocalTime, LocalDateTime
- Period, Duration
- DateTimeFormatter
- JUnit 5
- Maven
