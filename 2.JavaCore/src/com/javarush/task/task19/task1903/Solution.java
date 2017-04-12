package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA" ,"Ukraine");
        countries.put("RU" ,"Russia");
        countries.put("CA" ,"Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        IncomeDataAdapter(IncomeData incomeData){
            this.data = incomeData;
        }
        public String getName(){
            return this.data.getContactLastName()+", "+this.data.getContactFirstName();
        }
        public  String getCompanyName(){
           return this.data.getCompany();
        }
        public String getCountryName(){
            String country = this.data.getCountryCode();
            for (Map.Entry<String, String>pair :countries.entrySet()) {
                if(country.equals(pair.getKey()))
                    country = pair.getValue();
            }
            return country;
        }
            public String getPhoneNumber() {
                String number = String.valueOf(this.data.getPhoneNumber());
                // дополняем при необходимости до 10 символов
                if (number.length() < 10) {
                    String newNumber = ("0000000000" + number);
                    number = newNumber.substring(newNumber.length() - 10);
                }
                String result = String.format("+%s(%s)%s-%s-%s",
                        this.data.getCountryPhoneCode(),
                        number.substring(0,3),
                        number.substring(3,6),
                        number.substring(6,8),
                        number.substring(8,10));
                return result;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}