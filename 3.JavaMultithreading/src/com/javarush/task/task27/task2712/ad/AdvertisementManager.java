package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> videos = getOptimalVideos();

        for (Advertisement video : videos) {
            displayInPlayer(video);

            video.revalidate();
        }
    }

    private List<Advertisement> getOptimalVideos() {
        List<SortedVideoKit> videoKits = new ArrayList<>();
        List<List<Advertisement>> combinations = getVideoCombinations(storage.list());
//        System.out.println("Combination: " + combinations.size());
        for (List<Advertisement> combination : combinations) {
            SortedVideoKit videoKit = new SortedVideoKit(combination);

            if (videoKit.duration <= timeSeconds) {
                videoKits.add(videoKit);
            }
        }

        Collections.sort(videoKits);
//        System.out.println("Dur.: " + videoKits.get(0).duration + " amount: " + videoKits.get(0).amount);
        return videoKits.get(0).getVideos();
    }


    private List<List<Advertisement>> getVideoCombinations(List<Advertisement> videos) {
        List<List<Advertisement>> result = new ArrayList<>();

        if (videos.size() > 0) {
            result.add(videos);
        }

        for (int i = 0; i < videos.size(); i++) {
            Advertisement video = videos.get(i);

            List<Advertisement> copy = new ArrayList<>(videos);
            copy.remove(video);

            List<List<Advertisement>> combinations = getVideoCombinations(copy);

            for (List<Advertisement> combination : combinations) {
                if (!result.contains(combination)) {
                    result.add(combination);
                }
            }
        }

        return result;
    }

    private void displayInPlayer(Advertisement advertisement) {
        System.out.println(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }

    private class SortedVideoKit implements Comparable<SortedVideoKit> {
        private List<Advertisement> videos;
        private int duration;
        private long amount;
        private int size;

        public SortedVideoKit(List<Advertisement> videos) {
            this.videos = new ArrayList<>(videos);

            defineData();
        }

        private Comparator<Advertisement> getComparator() {
            return  (Advertisement o1, Advertisement o2) -> {
                long amount1 = o1.getAmountPerOneDisplaying();
                long amount2 = o2.getAmountPerOneDisplaying();

                if (amount1 == amount2) {
                    long amountPerSec1 = (amount1 * 1000)/o1.getDuration();
                    long amountPerSec2 = (amount2 * 1000)/o2.getDuration();

                    if (amountPerSec1 == amountPerSec2) {
                        return 0;
                    }

                    return amountPerSec1 > amountPerSec2 ? 1 : -1;
                }

                return amount1 < amount2 ? 1 : -1;
            };
        }

        public List<Advertisement> getVideos() {
            defineData();

            Collections.sort(videos, getComparator());

            return videos;
        }

        private void defineData() {
            List<Advertisement> videos = new ArrayList<>();

            duration = 0;
            amount = 0;
            size = 0;

            for (Advertisement video : this.videos) {
                if (video.getAmountPerOneDisplaying() > 0 && !videos.contains(video)) {

                    duration += video.getDuration();
                    amount += video.getAmountPerOneDisplaying();
                    size++;

                    videos.add(video);
                }
            }

            this.videos = videos;
        }

        @Override
        public int compareTo(SortedVideoKit o) {
            o.defineData();
            defineData();

            if (amount == o.amount) {
                if (duration == o.duration) {
                    if (size == o.size) {
                        return 0;
                    }

                    return size > o.size ? 1 : -1;
                }

                return duration < o.duration ? 1 : -1;
            }

            return amount < o.amount ? 1 : -1;
        }
    }
}