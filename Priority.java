import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Priority: " + priority + " - " + description;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}

public class Priority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PriorityQueue to store tasks, with the highest priority first
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t2.getPriority() - t1.getPriority());

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (1 - high, 10 - low): ");
                    int priority = scanner.nextInt();
                    taskQueue.add(new Task(priority, description));
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Tasks in priority order:");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 3:
                    Task removedTask = taskQueue.poll();
                    if (removedTask != null) {
                        System.out.println("Removed task: " + removedTask);
                    } else {
                        System.out.println("No tasks to remove.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Task Manager...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
