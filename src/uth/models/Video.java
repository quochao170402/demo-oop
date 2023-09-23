package uth.models;

public class Video {
    private final double id;
    private String title;

    public Video(double id, String title) {
        this.id = id;
        this.title = title;
    }

    public double getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
