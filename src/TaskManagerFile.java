import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManagerFile {
    private static String fileName;
    File file;
    FileWriter writer;

    TaskManagerFile(String fileName) {
        TaskManagerFile.fileName = fileName;
        createFile();
    }

    public void createFile() {
        try {
            file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File Yaradildi: " + file.getName());
            } else {
                System.out.println("--------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertFile(String task, String date, String priority) {
        try {
            //int taskNumber = getTaskCount();
            writer = new FileWriter(fileName, true);
            writer.write(getTaskCount() + ". Task: " + task + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Priority: " + priority + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                System.out.println(input);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getTaskCount() {
        int taskNumber = 1;
        int count = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
/*
                if (input.substring(1).startsWith(". Task: ")) { // 1-ci üsul
                    taskNumber++;
                }
*/
                count++; // 2-ci üsul
                if(count ==3){
                    taskNumber++;
                    count =0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return taskNumber;
    }

    public static void deleteTask(int no){
        int taskNumber = 1;
        int count = 0;

        String temp = "";
        try{
            File file = new File("ToDoList.txt");
            Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String input = sc.nextLine();

            count++;
            if(count == 3){
                taskNumber++;
                count = 0;
            }
            if(no != taskNumber){
                temp += input+"\n";
            }
        }
            try {
                FileWriter writer = new FileWriter("ToDoList.txt");
                writer.write(temp);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
