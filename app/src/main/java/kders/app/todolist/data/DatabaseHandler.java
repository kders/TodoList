package kders.app.todolist.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import kders.app.todolist.domain.Project;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Todos";

    private static final String TABLE_PROJECT = "Project";
    private static final String KEY_ID = "projectId";
    private static final String KEY_NAME = "name";
    private static final String KEY_IS_PRIVATE = "isPrivate";
    private static final String KEY_DUE_DATE = "dueDate";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE =
                "CREATE TABLE " + TABLE_PROJECT + "("
                        + KEY_ID + " INTEGER PRIMARY KEY,"
                        + KEY_NAME + " TEXT,"
                        + KEY_IS_PRIVATE + " TEXT"
                        + KEY_DUE_DATE + " TEXT,"
                        + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);
        onCreate(db);
    }

    public void addProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, project.getName());
        values.put(KEY_IS_PRIVATE, project.isPrivate());
        values.put(KEY_DUE_DATE, project.getDueDate());
        db.insert(TABLE_PROJECT, null, values);
        db.close();
    }

    public Project getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROJECT, new String[]{KEY_ID,
                        KEY_NAME, KEY_IS_PRIVATE, KEY_DUE_DATE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Project project = new Project(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getLong(3));
        return project;
    }

    public List<Project> getAllContacts() {
        List<Project> projectList = new ArrayList<Project>();
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
        String countQuery = "SELECT  * FROM " + TABLE_PROJECT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public int updateProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, project.getName());
        values.put(KEY_IS_PRIVATE, project.isPrivate());
        values.put(KEY_DUE_DATE, project.getDueDate());

        return db.update(TABLE_PROJECT, values, KEY_ID + " = ?",
                new String[] { String.valueOf(project.getProjectId()) });
    }

    public void deleteProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROJECT, KEY_ID + " = ?",
                new String[] { String.valueOf(project.getProjectId()) });
        db.close();
    }


}
