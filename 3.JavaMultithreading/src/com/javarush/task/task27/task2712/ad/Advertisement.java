package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = getAmountPerOneDisplaying();
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }

        hits--;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return hits == 0 ? 0 : initialAmount/hits;
    }

    //TODO: remove
    @Override
    public String toString() {
        return "Advertisement{" +
                "content=" + content +
                ", name='" + name + '\'' +
                ", initialAmount=" + initialAmount +
                ", hits=" + hits +
                ", duration=" + duration +
                ", amountPerOneDisplaying=" + amountPerOneDisplaying + " sec-" + (amountPerOneDisplaying * 1000)/duration +
                '}';
    }
}
