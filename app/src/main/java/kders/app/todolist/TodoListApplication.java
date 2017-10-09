package kders.app.todolist;

import android.app.Application;
import android.content.Context;

/**
 * Created by khanhngan on 02/10/2017.
 */

public class TodoListApplication extends Application{
    static Context mInstance;
    public static Context getContext() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = getApplicationContext();
    }
}
