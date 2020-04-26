package selab.threetier.logic;

import selab.threetier.storage.EntityStorage;
import selab.threetier.storage.Storage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Task extends Entity {
    private String title;
    private Date start;
    private Date end;

    public String getTitle() { return title; }
    public void setTitle(String value) { title = value; }

    public void setStart(Date value) { start = value; }
    public String getStartDate() {return new SimpleDateFormat("yyyy-MM-dd").format(start);}
    public String getStartTime() {
        return new SimpleDateFormat("HH:mm:ss").format(start);
    }

    public void setEnd(Date value) { end = value; }
    public String getEndTime() {
        return new SimpleDateFormat("HH:mm:ss").format(end);
    }
    public String getEndDate() {return new SimpleDateFormat("yyyy-MM-dd").format(end);
    }

    public void save() {
        Storage.getInstance().getTasks().addOrUpdate(this);
        EntityStorage<Task> allTasks= Storage.getInstance().getTasks();


    }
    public static void remove(int id) {Storage.getInstance().getTasks().rem(id);}



    public static ArrayList<Task> getAll() {
        ArrayList<Task> allTasks = Storage.getInstance().getTasks().getAll();
        Collections.sort(allTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.start.compareTo(t2.start);
            }
        });

        return allTasks;
    }
}
