package com.javarush.task.task20.task2002;

import com.sun.javafx.image.IntPixelGetter;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:/1.txt");
            OutputStream outputStream1 = new FileOutputStream("D:/2.txt");
            InputStream inputStream = new FileInputStream("D:/1.txt");
            JavaRush javaRush = new JavaRush();
            //GregorianCalendar calendar1 = new GregorianCalendar(year, month, day);
            //GregorianCalendar calendar2 = new GregorianCalendar(year, month, day);
            javaRush.users.add(new User("Ivan","Marzol",new Date(34235457),true, User.Country.UKRAINE));
            javaRush.users.add(new User("Ivan","Joglich",new Date(56345435),true, User.Country.RUSSIA));
            javaRush.save(outputStream);

            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            loadedObject.save(outputStream1);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject) ? "true" : "false");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (users != null) {
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(users.size());
                for (int i = 0; i < users.size(); i++) {
                    printWriter.println(users.get(i).getFirstName());
                    printWriter.println(users.get(i).getLastName());
                    printWriter.println(users.get(i).getBirthDate().getTime());
                    printWriter.println(users.get(i).isMale());
                    printWriter.println(users.get(i).getCountry());
                    printWriter.println();
                }
                printWriter.flush();
                printWriter.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                while (reader.ready()) {
                    int count = Integer.parseInt(reader.readLine());
                    for (int i = 0; i < count; i++) {
                        String firstName = reader.readLine();
                        String lastName = reader.readLine();
                        int birthday = Integer.parseInt(reader.readLine());
                        String male = reader.readLine();
                        String country = reader.readLine();
                        reader.readLine();
                        User user = new User();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        user.setBirthDate(new Date(birthday));
                        if (country.equals("UKRAINE"))
                            user.setCountry(User.Country.UKRAINE);
                        if (country.equals("RUSSIA"))
                            user.setCountry(User.Country.RUSSIA);
                        if (country.equals("OTHER"))
                            user.setCountry(User.Country.OTHER);
                        if(male.equals("true"))
                            user.setMale(true);
                        else
                            user.setMale(false);
                        users.add(user);
                    }
                }
            }catch (Exception e){

            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
