import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();

    }

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----To-Do List-----");
        System.out.println("1: Create a new task");
        System.out.println("2: Display all tasks");
        System.out.println("3: Delete a task");
        System.out.println("0: Exit");
        System.out.print("Secim et: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                CreateTask();
                break;
            case 2:
                DisplayTask();
                break;
            case 3:
                DeleteTask();
                break;
            case 0:
                Exit();
                break;
            default:
                System.out.println("Duzgun secim edin");
                Menu();
        }
    }

    public static void CreateTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("My To-Do List");
        System.out.print("Task: ");
        String t = sc.nextLine();

        System.out.print("Date: ");
        String d = sc.nextLine();

        System.out.print("Priority: ");
        String p = sc.nextLine();


        Task newTask = new Task("ToDoList.txt", t, d, p);
        newTask.createList();

        System.out.println("Would you like to create another task? Yes/No");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("Yes")) {
            CreateTask();
        } else {
            Menu();
        }

    }

    public static void DisplayTask() {
        System.out.println("My All To-Do List");
        Task task = new Task("ToDoList.txt", "", "", "");
        task.displayList();
        Menu();

    }

    public static void DeleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a task to delete: ");
        int no = sc.nextInt();
        TaskManagerFile.deleteTask(no);
        Menu();
        .
    }

    public static void Exit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Çıxış etməyinizə əminsinizmi? Beli/Xeyr");
        String choice = sc.nextLine();
        if (choice.equals("Beli")) {
            System.out.println("****************************");
            System.out.println("Ugurla çıxış edildi!");
        } else {
            System.out.println("Hələ də sistemdəsən!\n");
            Menu();
        }
    }
}