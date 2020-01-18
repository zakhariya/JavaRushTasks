package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            return getFormattedPhoneNumber(data.getCountryPhoneCode(), data.getPhoneNumber());
        }

        private String getFormattedPhoneNumber(int phoneCode, int phoneNumber) {
            String number = String.valueOf(phoneNumber);

            while (number.length() < 10) {
                number = "0" + number;
            }

            char[] numbers = number.toCharArray();
            char[] phone = new char[14];

            phone[0] = '(';
            phone[1] = numbers[0];
            phone[2] = numbers[1];
            phone[3] = numbers[2];
            phone[4] = ')';
            phone[5] = numbers[3];
            phone[6] = numbers[4];
            phone[7] = numbers[5];
            phone[8] = '-';
            phone[9] = numbers[6];
            phone[10] = numbers[7];
            phone[11] = '-';
            phone[12] = numbers[8];
            phone[13] = numbers[9];

            return String.format("+%s%s", String.valueOf(phoneCode), String.valueOf(phone));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}