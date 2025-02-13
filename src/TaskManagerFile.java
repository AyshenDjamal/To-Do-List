import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManagerFile {
    private String fileName;
    File file;
    FileWriter writer;

    TaskManagerFile(String fileName) {
        this.fileName = fileName;
        createFile();
    }

    public void createFile() {
        try {
            file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File Yaradildi: " + file.getName());
            } else {
                System.out.println("File movcuddur");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertFile(String task, String date, String priority) {
        try {
            int taskNumber = getTaskCount();
            writer = new FileWriter(fileName, true);
            writer.write(taskNumber+". Task: " + task + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Priority: " + priority + "\n\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTaskCount() {
        int taskNumber = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                taskNumber++;
                if (input.matches(". Task: ")) {
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return taskNumber;
}

    public void readFile() {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                System.out.println(input);
            }
            //sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
