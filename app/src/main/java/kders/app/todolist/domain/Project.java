package kders.app.todolist.domain;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class Project {
    int projectId;
    String name;
    boolean isPrivate;
    long dueDate;

    public Project(int projectId, String name, int isPrivate, long dueDate) {
        this.projectId = projectId;
        this.name = name;
        this.isPrivate = isPrivate == 1;
        this.dueDate = dueDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }
}
