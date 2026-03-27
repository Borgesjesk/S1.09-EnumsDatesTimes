# N1 - Enums 🎯

Introduction to Java enums: type-safe constants with built-in
behaviour, used in conditions and classes, with proper error
handling for invalid conversions.

---

## ✨ Exercises
- **Ex1:** `Day` enum with `isWeekend()` and `isWorkday()` — prints whether each day is a workday or weekend
- **Ex2:** `Level` enum (LOW, MEDIUM, HIGH) used in `Task` class — behaviour changes based on level
- **Ex3:** `Level` enum with `getColor()` and `getDescription()` methods demonstrating enum logic
- **Ex4:** `Level.valueOf()` converts Strings to enum values — handles invalid values with `IllegalArgumentException`

---

## 🚀 How to run
```bash
mvn compile exec:java -Dexec.mainClass="cat.itacademy.s1_09.n1.Main"
```

---

## 🛠 Technologies
- Java 21
- Java Enums with methods
- Switch expressions
- Maven