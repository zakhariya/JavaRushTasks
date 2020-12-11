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

        List<Advertisement> videos = getMaxProfitVideoList();

        for (Advertisement video : videos) {
//            video.revalidate();

//            System.out.println(video.toString());
        }
    }

    private List<Advertisement> getMaxProfitVideoList() {
        List<Advertisement> videos = new ArrayList<>(storage.list());

        List<SortedVideoKit> videoKits = createVideoKits(videos);

        Collections.sort(videoKits);

        //TODO: remove
        for (SortedVideoKit kit : videoKits) {
            System.out.println(kit);
        }

        return videoKits.get(0).getVideos();
    }

    private List<SortedVideoKit> createVideoKits(List<Advertisement> videos) {
        List<SortedVideoKit> videoKits = new ArrayList<>();

        for (int i = 0; i < videos.size(); i++) {
            List<Advertisement> newVideos = new ArrayList<>(videos);

            SortedVideoKit videoKit = new SortedVideoKit(newVideos);
            videoKits.add(videoKit);

            newVideos.remove(i);

            videoKits.addAll(createVideoKits(newVideos));
        }

        return videoKits;
    }

    private class SortedVideoKit implements Comparable<SortedVideoKit> {
        private final List<Advertisement> videos;
        private final int duration;
        private final long amount;
        private final int size;

        public SortedVideoKit(List<Advertisement> videos) {
            int duration = 0;
            long amount = 0;

            for (Advertisement video : videos) {
                duration += video.getDuration();
                amount += video.getAmountPerOneDisplaying();
            }

            this.videos = new ArrayList<>(videos);
            this.duration = duration;
            this.amount = amount;
            this.size = videos.size();
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
            Collections.sort(videos, getComparator());

            return videos;
        }

        @Override
        public int compareTo(SortedVideoKit o) {
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

        //TODO: remove
        @Override
        public String toString() {
            return "SortedVideoKit{" +
                    "videosCount=" + videos.size() +
                    ", duration=" + duration +
                    ", amount=" + amount +
                    ", size=" + size +
                    '}';
        }
    }
}