package DataProcessing;

import DataGroups.DataGroups;
import Structures.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortData {

    public double getAverageRating(DataGroups dataGroups) {
        double ratingSum = 0;
        double ratingAmount = 0;
        Person[] persons = dataGroups.getPersons();
        for (Person person : persons) {
            if (person != null) {
                String[] rating = person.getRating();
                for (String markStr : rating) {
                    double markInt = Double.parseDouble(markStr);
                    ratingSum += markInt;
                    ratingAmount++;
                }
            }
        }
        if (ratingAmount == 0) {
            ratingAmount++;
        }
        return ratingSum / ratingAmount;
    }

    public DataGroups getExcellentOlder(DataGroups dataGroups, int age){
        DataGroups dataGroupsExcellent = new DataGroups();
        for(Person person : dataGroups.getPersons()){
            if (person != null) {
                if (person.getAge() > age && isExcellentRating(person.getRating())){
                    dataGroupsExcellent.addPerson(person);
                }
            }
        }
        return dataGroupsExcellent;
    }

    public DataGroups getByFamily(DataGroups dataGroups){
        String userInput = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите фамилию для поиска: ");
            userInput = reader.readLine().trim();
        }catch (IOException e){
            e.printStackTrace();
        }
        DataGroups dataGroups1 = new DataGroups();
        for (Person person : dataGroups.getPersons()){
            if (person != null) {
                if (person.getFamily().equals(userInput)) {
                    dataGroups1.addPerson(person);
                }
            }
        }
        return dataGroups1;
    }

    private boolean isExcellentRating(String[] rating){
        int count = 0;
        for(String str : rating){
            if(Integer.parseInt(str) == 5){
                count++;
            }
        }
        return count == rating.length;
    }
}
