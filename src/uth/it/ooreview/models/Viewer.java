package uth.it.ooreview.models;

import uth.it.ooreview.utils.WriteFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Viewer extends User {
    private String[] interest;
    private List<Youtuber> youtubers;
    private Video curWatch;

    public Viewer(double id, String name)  {
        super(id, name);
        this.youtubers = new ArrayList<>();
    }

    @Override
    public Collection<Video> getVideos() {
        return null;
    }

    public String[] getInterest() {
        return interest;
    }

    public List<Youtuber> getYoutubers() {
        return youtubers;
    }

    public Video getCurWatch() {
        return curWatch;
    }

    public void setInterest(String[] interests) {
        this.interest = interests;
    }


    public void watchVideo(Video video) {
        System.out.println(this.name + " are watching: " + video.getTitle());
        videos.add(video);
        this.curWatch = video;

    }

    public void getSubNotification(Youtuber channel) {
        System.out.println("Thank " + this.name + " for subscribing to: " + channel.getName());
    }

    public void getUnSubNotification(Youtuber channel) {
        System.out.println(this.name + " have unsubscribed to: " + channel.getName());
    }

    public void getNewVideoNotification(Youtuber channel, Video video) {
        System.out.println("New video on " + channel.getName() + " channel: " + video.getTitle());
    }

    public void subscribe(Youtuber youtuber) {
        youtuber.addViewer(this);
        this.youtubers.add(youtuber);
    }

    public void unsubscribe(Youtuber youtuber) {
        youtuber.deleteViewer(this);
        this.youtubers.remove(youtuber);
    }

    public Youtuber findYoutuber(double id) {
        for (Youtuber youtuber : this.youtubers)
            if (id == youtuber.getId())
                return youtuber;
        return null;
    }

    public void exportYoutuberList(String path) {
        WriteFile wt = new WriteFile();
        wt.setContent(this.youtubers);
        wt.writeListToFile(path);
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interest=" + Arrays.toString(interest) +
                ", youtubers=" + youtubers +
                '}';
    }


}
