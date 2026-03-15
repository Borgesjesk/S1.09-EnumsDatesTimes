package cat.itacademy.s1_09.n1;

public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    public boolean isWorkday() {
        return !isWeekend();
    }
}