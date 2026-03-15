package cat.itacademy.s1_09.n1;

public class Task {

    private final String name;
    private final Level level;

    public Task(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public String getName() { return name; }
    public Level getLevel() { return level; }

    public void printInfo() {
        System.out.println("Task: " + name);
        System.out.println("  Level:       " + level);
        System.out.println("  Color:       " + level.getColor());
        System.out.println("  Description: " + level.getDescription());
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', level=" + level + "}";
    }
}