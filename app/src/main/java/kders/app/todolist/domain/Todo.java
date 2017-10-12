package kders.app.todolist.domain;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class Todo extends Task{

    public Todo(int taskId, String title, String description, long dueDate, long notifyDate, int priority, int projectId, String note, int memberId, long repeatTime, long location, boolean isDone) {
        super(taskId, title, description, dueDate, notifyDate, priority, projectId, note, memberId, repeatTime, location, isDone);
    }
}
