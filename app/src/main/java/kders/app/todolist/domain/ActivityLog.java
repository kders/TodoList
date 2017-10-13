package kders.app.todolist.domain;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class ActivityLog {
    long timestamp;
    String log;

    public ActivityLog(long timestamp, String log) {
        this.timestamp = timestamp;
        this.log = log;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object obj) {
        ActivityLog thatLog = (ActivityLog) obj;
        return (this.log != null) && (thatLog.log != null) && (this.log.equals(thatLog.log))
                && (this.timestamp == thatLog.timestamp);
    }
}
