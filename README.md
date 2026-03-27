# S1.09 - Enums, Dates and Times 🗓️

A sprint covering three fundamental Java topics: enums for type-safe
constants with behaviour, the java.time API for robust date and time
handling, and a first look at Java records as a modern alternative to
traditional classes.

---

## ✨ What's inside

### Level 1 - Enums
- **Ex1:** `Day` enum with `isWeekend()` and `isWorkday()` methods
- **Ex2:** `Level` enum (LOW, MEDIUM, HIGH) used in a `Task` class — behaviour changes per level
- **Ex3:** `Level` enum with `getColor()` and `getDescription()` methods
- **Ex4:** `Level.valueOf()` converts Strings to enum values — handles invalid input with `IllegalArgumentException`

### Level 2 - Dates and Times
- **Ex1:** Display current `LocalDate`, `LocalTime` and `LocalDateTime`
- **Ex2:** Calculate difference between two dates using `Period` and `Duration`
- **Ex3:** Add and subtract days, months, years and hours via `DateUtils`
- **Ex4:** Format dates with `DateTimeFormatter` in multiple patterns
- **Ex5:** `isBeforeToday()` — checks if a date is in the past
- **Ex6:** Agenda of `Appointment` objects filtered and sorted via `AgendaService`

---

## 🚀 How to run

Make sure you have **JDK 21** and **Maven** installed.
```bash
git clone https://github.com/Borgesjesk/S1.09-EnumsDatesTimes.git
cd S1.09-EnumsDatesTimes
```

**Run Level 1:**
```bash
mvn compile exec:java -Dexec.mainClass="cat.itacademy.s1_09.n1.Main"
```

**Run Level 2:**
```bash
mvn compile exec:java -Dexec.mainClass="cat.itacademy.s1_09.n2.Main"
```

---

## 🧪 Tests

JUnit 5 tests covering the core utility classes:

| Test class | What it covers |
| :--- | :--- |
| `DateUtilsTest` | `isBeforeToday()` for past/future dates, `formatDate()` output, `addDays()` arithmetic |
| `AgendaServiceTest` | filters past appointments, sorts by date, handles empty agenda |

Run all tests:
```bash
mvn test
```

---

## 🧠 Technical reflection: records vs traditional classes

This sprint introduced Java `record` as a modern way to declare data classes.

### Traditional class (used in `Appointment`)
- Requires manual constructor, getters, `equals()`, `hashCode()`, `toString()`
- Fields are **mutable** by default — you can change values after creation
- Better when the object needs behaviour or mutable state

### Java `record`
- Declares everything in one line: `record Appointment(String title, LocalDateTime dateTime) {}`
- Fields are **immutable** — perfect for data that shouldn't change
- Automatically generates constructor, getters, `equals()`, `hashCode()`, `toString()`
- Ideal for DTOs, value objects, or any class that just holds data

In this sprint `Appointment` could have been a `record` since it only holds data and never changes after creation. A traditional class was used here to practice the full structure explicitly.

---

## 🛠 Technologies
- Java 21
- Java Enums with methods
- java.time API (LocalDate, LocalTime, LocalDateTime, Period, Duration, DateTimeFormatter)
- JUnit 5
- Maven