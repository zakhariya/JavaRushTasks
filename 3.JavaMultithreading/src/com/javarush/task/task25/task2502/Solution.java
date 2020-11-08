package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            List<String> wheelNames = Arrays.asList(loadWheelNamesFromDB());
            wheels = new ArrayList<>(4);

            if (wheelNames != null && wheelNames.size() == 4) {
                for (Wheel wheel : Wheel.values()) {
                  if (wheelNames.contains(wheel.name()) && !wheels.contains(wheel)) {
                        wheels.add(wheel);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
