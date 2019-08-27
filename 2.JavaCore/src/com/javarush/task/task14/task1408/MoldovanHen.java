package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    private int eggsCount = 12;

    @Override
    public int getCountOfEggsPerMonth() {
        return eggsCount;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + " Моя страна - " + Country.MOLDOVA
                + ". Я несу " + eggsCount + " яиц в месяц.";
    }
}