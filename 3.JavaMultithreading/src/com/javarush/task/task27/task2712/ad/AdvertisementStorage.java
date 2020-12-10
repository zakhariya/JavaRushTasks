package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();

        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        videos.add(new Advertisement(someContent, "First2 Video", 5000, 100, 2 * 60));
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
        videos.add(new Advertisement(someContent, "Third2 Video", 400, 2, 11 * 60));
        videos.add(new Advertisement(someContent, "Fourth Video", 2000, 37, 7 * 60));
        videos.add(new Advertisement(someContent, "Fifth Video", 450, 3, 5 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }

        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
