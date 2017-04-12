package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA" ,"Ukraine");
        countries.put("RU" ,"Russia");
        countries.put("CA" ,"Canada");
    }
    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        public String getCountryCode(){
                String countryCode = "";
                for (Map.Entry entry : countries.entrySet())
                {
                    if (customer.getCountryName().equals((String) entry.getValue())) {
                        countryCode = (String) entry.getKey();
                        break;
                    }
                }
                return countryCode;
            }

        public String getCompany() {
            String companyName = customer.getCompanyName();
            return companyName;
        }
        public String getContactFirstName() {
            String firstName = contact.getName().split(", ")[1];
            return firstName;
        }
        public String getContactLastName() {
            String lastName = contact.getName().split(", ")[0];
            return lastName;
        }
        public String getDialString() {
            String dial = "callto://+" + contact.getPhoneNumber().replaceAll("[^0-9]", "");
            return dial;
        }
    }


    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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