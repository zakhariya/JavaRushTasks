package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    private int eggsCount = 15;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggsCount;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " Моя страна - " + Country.UKRAINE
                + ". Я несу " + eggsCount + " яиц в месяц.";
    }
}