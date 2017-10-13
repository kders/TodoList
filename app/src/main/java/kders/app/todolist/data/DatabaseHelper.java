package kders.app.todolist.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import kders.app.todolist.domain.Project;
import kders.app.todolist.domain.Task;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Todos.db";

    private static final String TABLE_PROJECT = "Project";
    private static final String KEY_PROJECT_ID = "projectId";
    private static final String KEY_PROJECT_NAME = "name";
    private static final String KEY_PROJECT_IS_PRIVATE = "isPrivate";
    private static final String KEY_PROJECT_DUE_DATE = "dueDate";

    private static final String TABLE_TASK = "Task";
    private static final String KEY_TASK_ID = "taskId";
    private static final String KEY_TASK_TITLE = "title";
    private static final String KEY_TASK_DESCRIPTION = "description";
    private static final String KEY_TASK_DUE_DATE = "dueDate";
    private static final String KEY_TASK_NOTIFY_DATE = "notifyDate";
    private static final String KEY_TASK_PRIORITY = "priority";
    private static final String KEY_TASK_PROJECT_ID = "projectId";
    private static final String KEY_TASK_NOTE = "note";
    private static final String KEY_TASK_MEMBER_ID = "memberId";
    private static final String KEY_TASK_REAPEAT_TIME = "repeatTime";
    private static final String KEY_TASK_LOCATION = "location";
    private static final String KEY_TASK_IS_DONE = "isDone";

    private static final String TABLE_ATTACHMENT = "Attachment";
    private static final String KEY_ATTACHMENT_ID = "attachmentId";
    private static final String KEY_ATTACHMENT_URI = "URI";

    private static final String TABLE_ACTIVITY_LOG = "ActivityLog";
    private static final String KEY_ACTIVITY_LOG_TIMESTAMP = "timestamp";
    private static final String KEY_ACTIVITY_LOG = "log";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PROJECT =
                "CREATE TABLE " + TABLE_PROJECT + "("
                        + KEY_PROJECT_ID + " INTEGER PRIMARY KEY,"
                        + KEY_PROJECT_NAME + " TEXT,"
                        + KEY_PROJECT_IS_PRIVATE + " INTEGER,"
                        + KEY_PROJECT_DUE_DATE + " INTEGER"
                        + ")";

        String CREATE_TABLE_TASK =
                "CREATE TABLE " + TABLE_TASK + "("
                        + KEY_TASK_ID + " INTEGER PRIMARY KEY,"
                        + KEY_TASK_TITLE + " TEXT,"
                        + KEY_TASK_DESCRIPTION + " TEXT,"
                        + KEY_TASK_DUE_DATE + " INTEGER,"
                        + KEY_TASK_NOTIFY_DATE + " INTEGER,"
                        + KEY_TASK_PRIORITY + " INTEGER,"
                        + KEY_TASK_PROJECT_ID + " INTEGER,"
                        + KEY_TASK_NOTE + " TEXT,"
                        + KEY_TASK_MEMBER_ID + " INTEGER,"
                        + KEY_TASK_REAPEAT_TIME + " INTEGER,"
                        + KEY_TASK_LOCATION + " INTEGER,"
                        + KEY_TASK_IS_DONE + " INTEGER"
                        + ")";

        String CREATE_TABLE_ATTACHMENT =
                "CREATE TABLE " + TABLE_ATTACHMENT + "("
                        + KEY_ATTACHMENT_ID + " INTEGER PRIMARY KEY,"
                        + KEY_ATTACHMENT_URI + " TEXT"
                        + ")";

        String CREATE_TABLE_ACTIVITY_LOG =
                "CREATE TABLE " + TABLE_ACTIVITY_LOG + "("
                        + KEY_ACTIVITY_LOG_TIMESTAMP + " INTEGER PRIMARY KEY,"
                        + KEY_ACTIVITY_LOG + " TEXT"
                        + ")";

        db.execSQL(CREATE_TABLE_PROJECT);
        db.execSQL(CREATE_TABLE_TASK);
        db.execSQL(CREATE_TABLE_ATTACHMENT);
        db.execSQL(CREATE_TABLE_ACTIVITY_LOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTACHMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITY_LOG);
        onCreate(db);
    }

    public void addProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PROJECT_NAME, project.getName());
        values.put(KEY_PROJECT_IS_PRIVATE, project.isPrivate());
        values.put(KEY_PROJECT_DUE_DATE, project.getDueDate());
        db.insert(TABLE_PROJECT, null, values);
        db.close();
    }

    public Project getProject(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_PROJECT + " WHERE "
                + KEY_PROJECT_ID + " = " + id;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Project project = new Project(
                c.getInt(0),
                c.getString(1),
                c.getInt(2),
                c.getLong(3));

        c.close();
        return project;
    }

    public List<Project> getAllProjects() {
        List<Project> projectList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_PROJECT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Project project = new Project(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getLong(3));
                projectList.add(project);
            } while (cursor.moveToNext());
        }

        return projectList;
    }

    public int getProjectCount() {
        String countQuery = "SELECT * FROM " + TABLE_PROJECT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int updateProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PROJECT_NAME, project.getName());
        values.put(KEY_PROJECT_IS_PRIVATE, project.isPrivate());
        values.put(KEY_PROJECT_DUE_DATE, project.getDueDate());

        return db.update(TABLE_PROJECT, values, KEY_PROJECT_ID + " = ?",
                new String[]{String.valueOf(project.getProjectId())});
    }

    public void deleteProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROJECT, KEY_PROJECT_ID + " = ?",
                new String[]{String.valueOf(project.getProjectId())});
        db.close();
    }

    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_TASK_ID, task.getTaskId());
        values.put(KEY_TASK_TITLE, task.getTitle());
        values.put(KEY_TASK_DESCRIPTION, task.getDescription());
        values.put(KEY_TASK_DUE_DATE, task.getDueDate());
        values.put(KEY_TASK_NOTIFY_DATE, task.getNotifyDate());
        values.put(KEY_TASK_PRIORITY, task.getPriority());
        values.put(KEY_TASK_PROJECT_ID, task.getProjectId());
        values.put(KEY_TASK_NOTE, task.getNote());
        values.put(KEY_TASK_MEMBER_ID, task.getMemberId());
        values.put(KEY_TASK_REAPEAT_TIME, task.getRepeatTime());
        values.put(KEY_TASK_LOCATION, task.getLocation());
        values.put(KEY_TASK_IS_DONE, task.isDone());

        db.insert(TABLE_TASK, null, values);
        db.close();
    }

    public Task getTask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TASK + " WHERE "
                + KEY_TASK_ID + " = " + id;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Task task = new Task(
                c.getInt(0),
                c.getString(1),
                c.getString(2),
                c.getLong(3),
                c.getLong(4),
                c.getInt(5),
                c.getInt(6),
                c.getString(7),
                c.getInt(8),
                c.getLong(9),
                c.getLong(10),
                c.getInt(11));

        c.close();
        return task;
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Task task = new Task(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getLong(3),
                        cursor.getLong(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getString(7),
                        cursor.getInt(8),
                        cursor.getLong(9),
                        cursor.getLong(10),
                        cursor.getInt(11));

                taskList.add(task);
            } while (cursor.moveToNext());
        }

        return taskList;
    }

    public int getTaskCount() {
        String countQuery = "SELECT * FROM " + TABLE_TASK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int updateTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_TASK_ID, task.getTaskId());
        values.put(KEY_TASK_TITLE, task.getTitle());
        values.put(KEY_TASK_DESCRIPTION, task.getDescription());
        values.put(KEY_TASK_DUE_DATE, task.getDueDate());
        values.put(KEY_TASK_NOTIFY_DATE, task.getNotifyDate());
        values.put(KEY_TASK_PRIORITY, task.getPriority());
        values.put(KEY_TASK_PROJECT_ID, task.getProjectId());
        values.put(KEY_TASK_NOTE, task.getNote());
        values.put(KEY_TASK_MEMBER_ID, task.getMemberId());
        values.put(KEY_TASK_REAPEAT_TIME, task.getRepeatTime());
        values.put(KEY_TASK_LOCATION, task.getLocation());
        values.put(KEY_TASK_IS_DONE, task.isDone());

        return db.update(TABLE_TASK, values, KEY_TASK_ID + " = ?",
                new String[]{String.valueOf(task.getTaskId())});
    }

    public void deleteTask(Task project) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASK, KEY_TASK_ID + " = ?",
                new String[]{String.valueOf(project.getTaskId())});
        db.close();
    }
}
