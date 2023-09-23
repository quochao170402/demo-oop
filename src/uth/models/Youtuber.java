package uth.models;

import java.util.ArrayList;
import java.util.List;

public class Youtuber extends User {
    private final List<Viewer> viewerList;
    private String category;

    public Youtuber(double id, String name) {
        super(id, name);
        this.viewerList = new ArrayList<>();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(int cat) {
        Category[] categories = Category.values();
        for (Category c : categories) {
            if (cat == c.getCategory()) {
                this.category = c.name();
            }
        }
    }

    public void addVideo(Video video) {
        if (!this.videos.contains(video)) {
            this.videos.add(video);
        }
    }

    public Video searchVideo(double id) {
        for (Video v : this.videos)
            if (id == v.getId())
                return v;
        return null;
    }

    public void updateVideo(Video video, String title) {
        video.setTitle(title);
    }

    public void deleteVideo(Video video) {
        this.videos.remove(video);
    }
    public void addViewer(Viewer viewer) {
        if (!this.viewerList.contains(viewer)) {
            this.viewerList.add(viewer);
            viewer.getSubNotification(this);
        }
    }

    public Viewer searchViewer(double id) {
        for (Viewer v : this.viewerList)
            if (id == v.getId())
                return v;
        return null;
    }

    public void deleteViewer(Viewer viewer) {
        this.viewerList.remove(viewer);
        viewer.getUnSubNotification(this);
    }


    public List<Video> getVideoList() {
        return this.videos;
    }

    public void onNotification() {
        for (Viewer vw : this.viewerList) {
            for (Video vid : this.videos) {
                vw.getNewVideoNotification(this, vid);
            }
        }
    }

    @Override
    public String toString() {
        return "Youtuber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public enum Category {
        MUSIC(1),
        SPORT(2),
        ANIMAL(3),
        KID(4),
        NEWS(5),
        TECH(6),
        CAR(7);

        private final int cat;

        Category(int i) {
            this.cat = i;
        }

        public int getCategory() {
            return this.cat;
        }
    }
}
