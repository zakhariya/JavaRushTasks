package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    private int eggsCount = 14;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggsCount;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " Моя страна - " + Country.BELARUS
                + ". Я несу " + eggsCount + " яиц в месяц.";
    }
}