package kders.app.todolist.domain;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class Task {
    int taskId;
    String title;
    String description;
    long dueDate;
    long notifyDate;
    int priority;
    int projectId;
    String note;
    int memberId;
    long repeatTime;
    long location;
    boolean isDone;

    public Task(int taskId, String title, String description, long dueDate, long notifyDate,
                int priority, int projectId, String note, int memberId, long repeatTime,
                long location, int isDone) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.notifyDate = notifyDate;
        this.priority = priority;
        this.projectId = projectId;
        this.note = note;
        this.memberId = memberId;
        this.repeatTime = repeatTime;
        this.location = location;
        this.isDone = isDone == 1;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public long getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(long notifyDate) {
        this.notifyDate = notifyDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public long getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(long repeatTime) {
        this.repeatTime = repeatTime;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;

        return (this.title != null) && (task.title != null)
                && (this.title.equals(task.title))
                && (this.description != null) && (task.description != null)
                && (this.description.equals(task.description))
                && (this.dueDate == task.dueDate)
                && (this.notifyDate == task.notifyDate)
                && (this.note != null) && (task.note != null)
                && (this.note.equals(task.note))
                && (this.memberId == task.memberId)
                && (this.repeatTime == task.repeatTime)
                && (this.location == task.location)
                && (this.isDone == task.isDone);
    }
}
