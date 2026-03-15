package cat.itacademy.s1_09.n1;

public enum Level {
    LOW, MEDIUM, HIGH;

    public String getColor() {
        return switch (this) {
            case LOW -> "Green";
            case MEDIUM -> "Yellow";
            case HIGH -> "Red";
        };
    }

    public String getDescription() {
        return switch (this) {
            case LOW -> "Low priority — can wait";
            case MEDIUM -> "Medium priority — handle soon";
            case HIGH -> "High priority — handle immediately";
        };
    }
}