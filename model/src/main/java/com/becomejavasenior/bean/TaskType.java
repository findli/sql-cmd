package model.src.main.java.com.becomejavasenior.bean;

import java.io.Serializable;

public class TaskType implements Serializable {
    private int id;
    private String title;

    public TaskType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskType taskType = (TaskType) o;

        if (id != taskType.id) return false;
        return title != null ? title.equals(taskType.title) : taskType.title == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
