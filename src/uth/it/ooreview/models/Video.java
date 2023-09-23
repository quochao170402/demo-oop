package uth.it.ooreview.models;

public class Video {
    private double id;
    private String title;

    public Video(double id, String title) {
        this.id = id;
        this.title = title;
    }

    public double getId() {
        return this.id;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
