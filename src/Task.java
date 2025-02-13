public class Task extends TaskManagerFile{
    public String task;
    public String date;
    public String priority;

    Task(String fileName, String task, String date, String priority) {
        super(fileName);
        this.task = task;
        this.date = date;
        this.priority = priority;
    }

    public void createList() {
       insertFile(task, date, priority);
        System.out.println("Fayla tapsiriq elave edildi");
    }


    public void displayList() {

        readFile();
    }

    /*public Boolean deleteTask() {

    }
*/
}
