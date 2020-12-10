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

        List<Advertisement> videos = getMaxProfitAdvertisementList();

        for (Advertisement video : videos) {
//            video.revalidate();

            System.out.println(video.toString());
        }
    }

    private List<Advertisement> getMaxProfitAdvertisementList() {
        List<Advertisement> videos = new LinkedList<>(storage.list());

        List<SortedAdvertisementKit> kits = new LinkedList<>();

        kits.add(new SortedAdvertisementKit(videos));

        videos.remove(0);
        videos.remove(0);

        kits.add(new SortedAdvertisementKit(videos));

        videos.remove(0);

        kits.add(new SortedAdvertisementKit(videos));

        Collections.sort(kits);

        for (SortedAdvertisementKit kit : kits) {
            System.out.println(kit);
        }



        SortedAdvertisementKit advertisementKit = kits.get(0);

        return advertisementKit.getVideos();
    }

    private class SortedAdvertisementKit implements Comparable<SortedAdvertisementKit> {
        private final List<Advertisement> videos;
        private final int duration;
        private final long amount;
        private final int size;

        public SortedAdvertisementKit(List<Advertisement> videos) {
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

//        public int getDuration() {
//            return duration;
//        }
//
//        public long getAmount() {
//            return amount;
//        }
//
//        public int getSize() {
//            return size;
//        }

        @Override
        public int compareTo(SortedAdvertisementKit o) {
            if (amount == o.amount) {
//                if (duration == o.duration) {
//
//                }

                return 0;
            }

            return amount < o.amount ? 1 : -1;
        }

        //TODO: remove
        @Override
        public String toString() {
            return "SortedAdvertisementKit{" +
                    "videosCount=" + videos.size() +
                    ", duration=" + duration +
                    ", amount=" + amount +
                    ", size=" + size +
                    '}';
        }
    }
}
