package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            Human petrov = new Human("Petrov", new Asset("gold"));
            petrov.assets.get(0).setPrice(990000.91);
            petrov.save(outputStream);
            outputStream.flush();
            Human somePerson = new Human();
            somePerson.load(inputStream);
            Human somePerson2 = new Human();
            somePerson2.load(inputStream);
            System.out.println(ivanov.equals(somePerson) ? "true" : "false");
            System.out.println(petrov.equals(somePerson2) ? "true" : "false");
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            if (name != null) {
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(name);
                for (int i = 0; i < assets.size(); i++) {
                    printWriter.print(assets.get(i).getName() + " " + (assets.get(i).getPrice()) + " ");
                }
                printWriter.println();
                printWriter.flush();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            name = readLine(inputStream);
            String ass = readLine(inputStream);
            if (ass != ""){
                String[] temp = ass.split(" ");
            for (int i = 0; i < temp.length; i += 2) {
                Asset as = new Asset(temp[i]);
                as.setPrice(Double.parseDouble(temp[i + 1]));
                assets.add(as);
            }
            }
            //implement this method - реализуйте этот метод
        }

        public String readLine(InputStream inputStream) throws IOException {
            String s = "";
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (String.valueOf((char) data).equals("\n")) {
                    break;
                }
                s += (char) data;
            }
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Human human = (Human) obj;
            if (!name.equals(human.name)) return false;
            if (assets.size() != human.assets.size()) return false;
            for (int i = 0; i < assets.size(); i++) {
                if (!assets.get(i).getName().equals(human.assets.get(i).getName())) return false;
                if (assets.get(i).getPrice() != human.assets.get(i).getPrice()) return false;
            }
            return true;
        }
    }
}