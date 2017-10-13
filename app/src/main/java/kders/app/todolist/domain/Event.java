package kders.app.todolist.domain;

/**
 * Created by sev_user on 10/9/2017.
 */

public class Event extends Task {

    public Event(int taskId, String title, String description, long dueDate, long notifyDate, int priority, int projectId, String note, int memberId, long repeatTime, long location, int isDone) {
        super(taskId, title, description, dueDate, notifyDate, priority, projectId, note, memberId, repeatTime, location, isDone);
    }
}
