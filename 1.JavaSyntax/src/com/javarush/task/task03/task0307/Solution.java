package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Zerg> zergs = getUnits(Zerg.class, 5);
        ArrayList<Protoss> protosses = getUnits(Protoss.class, 3);
        ArrayList<Terran> terrans = getUnits(Terran.class, 4);
    }

    private static ArrayList getUnits(Class type, int count){
        ArrayList units;

        if(type.equals(Zerg.class)){
            units = new ArrayList<Zerg>();

            while (count-- > 0){
                Zerg zerg = new Zerg();
                zerg.name = "zg" + count;
                units.add(zerg);
            }

            return units;
        }else if(type.equals(Protoss.class)){
            units = new ArrayList<Protoss>();

            while (count-- > 0){
                Protoss protoss = new Protoss();
                protoss.name = "pt" + count;
                units.add(protoss);
            }

            return units;
        }else if(type.equals(Terran.class)){
            units = new ArrayList<Terran>();

            while (count-- > 0){
                Terran terran = new Terran();
                terran.name = "tr" + count;
                units.add(terran);
            }

            return units;
        }

        return null;
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
