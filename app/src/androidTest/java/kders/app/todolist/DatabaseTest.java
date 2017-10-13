package kders.app.todolist;

import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import kders.app.todolist.data.DatabaseHelper;
import kders.app.todolist.domain.Project;
import kders.app.todolist.domain.Task;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by xzen4ever on 10/13/2017.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    @Ignore
    public void DatabaseTest_Table_Project_CRUD() throws Exception {
        DatabaseHelper db = new DatabaseHelper(InstrumentationRegistry.getTargetContext());
        Project project = new Project(1, "Test", 1, System.currentTimeMillis());

        int oldCount = db.getProjectCount();
        //C
        db.addProject(project);
        assertEquals(oldCount + 1, db.getProjectCount());
        //R
        assertEquals(true, project.equals(db.getProject(1)));
        //U
        Project updatedProject = db.getProject(1);

        updatedProject.setName("Testtwo");
        db.updateProject(updatedProject);
        assertEquals("Testtwo", db.getProject(1).getName());

        updatedProject.setPrivate(false);
        db.updateProject(updatedProject);
        assertEquals(false, db.getProject(1).isPrivate());

        long updatedMillis = System.currentTimeMillis();
        updatedProject.setDueDate(updatedMillis);
        db.updateProject(updatedProject);
        assertEquals(updatedMillis, db.getProject(1).getDueDate());
        //D
        int currentCount = db.getProjectCount();
        db.deleteProject(db.getProject(1));
        assertEquals(currentCount - 1, db.getProjectCount());
    }

    @Test
    public void DatabaseTest_Table_Task_CRUD() throws Exception {
        DatabaseHelper db = new DatabaseHelper(InstrumentationRegistry.getTargetContext());
        Task task = new Task(1, "Title", "Description", System.currentTimeMillis(),
                System.currentTimeMillis()+1000, 10, 1, "Note", 100, 1000000, 4235785, 1);

        int oldCount = db.getTaskCount();
        //C
        db.addTask(task);
        assertEquals(oldCount + 1, db.getTaskCount());
        //R
        assertEquals(true, task.equals(db.getTask(1)));
        //U
        Task updatedTask = db.getTask(1);

        updatedTask.setTitle("Titletwo");
        db.updateTask(updatedTask);
        assertEquals("Titletwo", db.getTask(1).getTitle());

        updatedTask.setDescription("Descriptiontwo");
        db.updateTask(updatedTask);
        assertEquals("Descriptiontwo", db.getTask(1).getDescription());

        long updatedMillis = System.currentTimeMillis();
        updatedTask.setDueDate(updatedMillis);
        db.updateTask(updatedTask);
        assertEquals(updatedMillis, db.getTask(1).getDueDate());

        updatedMillis = System.currentTimeMillis() + 1000;
        updatedTask.setNotifyDate(updatedMillis);
        db.updateTask(updatedTask);
        assertEquals(updatedMillis, db.getTask(1).getNotifyDate());

        updatedTask.setPriority(11);
        db.updateTask(updatedTask);
        assertEquals(11, db.getTask(1).getPriority());

        updatedTask.setProjectId(2);
        db.updateTask(updatedTask);
        assertEquals(2, db.getTask(1).getProjectId());

        updatedTask.setNote("Notetwo");
        db.updateTask(updatedTask);
        assertEquals("Notetwo", db.getTask(1).getNote());

        updatedTask.setMemberId(200);
        db.updateTask(updatedTask);
        assertEquals(200, db.getTask(1).getMemberId());

        updatedMillis = System.currentTimeMillis() + 2000;
        updatedTask.setRepeatTime(updatedMillis);
        db.updateTask(updatedTask);
        assertEquals(updatedMillis, db.getTask(1).getRepeatTime());

        long updatedLocation = 4444444;
        updatedTask.setLocation(updatedLocation);
        db.updateTask(updatedTask);
        assertEquals(4444444, db.getTask(1).getLocation());

        updatedTask.setDone(false);
        db.updateTask(updatedTask);
        assertEquals(false, db.getTask(1).isDone());
        //D
        int currentCount = db.getTaskCount();
        db.deleteTask(db.getTask(1));
        assertEquals(currentCount - 1, db.getTaskCount());
    }
}