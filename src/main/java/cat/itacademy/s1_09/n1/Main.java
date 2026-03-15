package cat.itacademy.s1_09.n1;

public class Main {

    public static void printDayType(Day day) {
        if (day.isWeekend()) {
            System.out.println(day + " → Weekend 🎉");
        } else {
            System.out.println(day + " → Workday 💼");
        }
    }

    public static void main(String[] args) {

        // Ex1 - Day enum
        System.out.println("─".repeat(40));
        System.out.println("Ex1 - Day enum:");
        for (Day day : Day.values()) {
            printDayType(day);
        }

        // Ex2 - Task with Level enum
        System.out.println("─".repeat(40));
        System.out.println("Ex2 - Task with Level:");
        Task lowTask = new Task("Write documentation", Level.LOW);
        Task medTask = new Task("Fix bug", Level.MEDIUM);
        Task highTask = new Task("Server is down", Level.HIGH);

        lowTask.printInfo();
        System.out.println();
        medTask.printInfo();
        System.out.println();
        highTask.printInfo();

        // Ex3 - Level enum with methods
        System.out.println("─".repeat(40));
        System.out.println("Ex3 - Level enum methods:");
        for (Level level : Level.values()) {
            System.out.println(level + " → Color: " + level.getColor()
                    + " | " + level.getDescription());
        }

        // Ex4 - valueOf and error handling
        System.out.println("─".repeat(40));
        System.out.println("Ex4 - valueOf and error handling:");
        String[] inputs = {"HIGH", "LOW", "INVALID", "MEDIUM", "UNKNOWN"};
        for (String input : inputs) {
            try {
                Level level = Level.valueOf(input);
                System.out.println("'" + input + "' → valid Level: " + level);
            } catch (IllegalArgumentException e) {
                System.err.println("'" + input + "' → invalid Level: " + e.getMessage());
            }
        }
    }
}