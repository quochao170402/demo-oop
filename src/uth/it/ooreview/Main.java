package uth.it.ooreview;

import uth.it.ooreview.models.Video;
import uth.it.ooreview.models.Viewer;
import uth.it.ooreview.models.Youtuber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Videos
        Video v1 = new Video(1, "Learn Java in 5 minutes!");
        Video v2 = new Video(2, "JDK 21 Release Notes - Inside Java Newscast ");
        Video v3 = new Video(3, "The 15 fastest cars in the world 2023!");
        Video v4 = new Video(4, "Java tutorial for beginners 2021");
        Video v5 = new Video(5, "Review Bugatti Chiron");

        // Youtubers
        List<Youtuber> youtubers = new ArrayList<>();
        Youtuber youtuber1 = new Youtuber(1, "Huy Tran");
        youtuber1.setCategory(6);
        youtuber1.addVideo(v1);
        youtuber1.addVideo(v2);
        youtuber1.addVideo(v4);
        youtuber1.updateVideo(v4,"Make GUI with JAVA Spring");

        Youtuber youtuber2 = new Youtuber(2, "Supper Car");
        youtuber2.setCategory(7);
        youtuber2.addVideo(v3);
        youtuber2.addVideo(v5);

        youtubers.add(youtuber2);
        youtubers.add(youtuber1);
        System.out.println("===============Youtubers===============");
        youtubers.forEach(System.out::println);
        System.out.println("=======================================");
        // Viewers
        Viewer viewer1 = new Viewer(1, "ThoLe");
        String[] interests1 = new String[]{"TECH", "FUNNY", "MUSIC"};
        viewer1.setInterest(interests1);

        Viewer viewer2 = new Viewer(2, "HungAnhNguyen");
        String[] interests2 = new String[]{"NEWS", "CAR", "TECH"};
        viewer2.setInterest(interests2);

        // Business logic
        System.out.println();
        System.out.println("===============Logic===============");
        youtubers.forEach(youtuber -> {
            for (String s : interests1) {
                if (youtuber.getCategory().equals(s))
                    viewer1.subscribe(youtuber);
            }

            for (String s : interests2) {
                if (youtuber.getCategory().equals(s))
                    viewer2.subscribe(youtuber);
            }
        });

        viewer2.unsubscribe(youtuber1);
        youtuber1.deleteVideo(v2);
        youtubers.forEach(Youtuber::onNotification);
        youtuber1.getVideoList().forEach(viewer2::watchVideo);
        System.out.println("=====================================");

    }
}
