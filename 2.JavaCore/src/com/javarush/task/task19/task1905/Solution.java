package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem  {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            return getCountryCodeByName(customer.getCountryName());
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();

            return fullName.substring(fullName.indexOf(", ")).replace(", ", "");
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();

            return fullName.substring(0, fullName.indexOf(", "));
        }

        @Override
        public String getDialString() {
            String phoneNumber = contact.getPhoneNumber();

            String dialString = "";

            if (phoneNumber.contains("or")) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.indexOf("or"));
                dialString = removeChars(phoneNumber);
            } else {
                dialString = removeChars(phoneNumber);
            }

            return String.format("callto://%s", dialString);
        }

        private String getCountryCodeByName(String name) {
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(name)) {
                    return pair.getKey();
                }
            }

            return "";
        }

        private String removeChars(String phoneNumber) {
            phoneNumber = phoneNumber.replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");
            phoneNumber = phoneNumber.replace("-", "");
            phoneNumber = phoneNumber.replace(" ", "");

            return phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}