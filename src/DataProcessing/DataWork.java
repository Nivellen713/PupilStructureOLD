package DataProcessing;

import DataGroups.DataGroups;
import Structures.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Класс для обработки данных и нахождения учеников по заданным параметрам
public class DataWork {

    // вычисление средней оценки группы учеников
    public double getAverageRating(DataGroups dataGroups) {
        double ratingSum = 0;
        double ratingAmount = 0;
        Person[] persons = dataGroups.getPersons();
        for (Person person : persons) {
            if(person != null) {
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

    // поиск отличников старше заданного возраста
    public DataGroups getExcellentOlder(DataGroups dataGroups, int age) {
        DataGroups dataGroupsExcellent = new DataGroups();
        for (Person person : dataGroups.getPersons()) {
            if (person != null && person.getAge() > age && isExcellentRating(person.getRating())) {
                dataGroupsExcellent.addPerson(person);
            }
        }
        return dataGroupsExcellent;
    }

    // поиск учеников по фамилии
    public DataGroups getByLastName(DataGroups dataGroups) {
        String userInput = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите фамилию для поиска: ");
            userInput = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchByLastName(dataGroups, userInput);
    }

    private DataGroups searchByLastName(DataGroups dataGroups, String lastName) {
        dataGroups = searchByFirstLetter(dataGroups, String.valueOf(lastName.charAt(0)));
        Person[] persons = dataGroups.getPersons();
        DataGroups dataGroupsFind = new DataGroups();
        for (Person person : persons) {
            if (person != null && person.getLastName().equals(lastName)) {
                dataGroupsFind.addPerson(person);
            }
        }
        return dataGroupsFind;
    }

    // бинарный поиск первой буквы фамилии сложностью O(n log n)
    public DataGroups searchByFirstLetter(DataGroups dataGroups, String firstLetter) {
        DataGroups dataGroupsFind = new DataGroups();
        int firstLetterMiddleIndex = 0;
        Person[] persons = dataGroups.getPersons();
        int lowIndex = 0;
        int highIndex = persons.length;
        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            char personFirstLetter = persons[middleIndex].getLastName().charAt(0);
            char firstLetterToFind = firstLetter.charAt(0);
            if (personFirstLetter == firstLetterToFind) {
                firstLetterMiddleIndex = middleIndex;
                lowIndex = highIndex + 1;
            } else if (personFirstLetter < firstLetterToFind) {
                lowIndex = middleIndex + 1;
            } else if (personFirstLetter > firstLetterToFind) {
                highIndex = middleIndex - 1;
            }
        }
        // После нахождения первой буквы искомой фамилии в массиве делаем прохождение по найденному куску
        // (как следствие линейный поиск (O(n)) выполняется для меньшего количества объектов)
        for (int i = firstLetterMiddleIndex; persons[i].getLastName().charAt(0) == firstLetter.charAt(0); i++) {
            dataGroupsFind.addPerson(persons[i]);
        }
        for (int i = firstLetterMiddleIndex; persons[i].getLastName().charAt(0) == firstLetter.charAt(0); i--) {
            dataGroupsFind.addPerson(persons[i]);
        }
        return dataGroupsFind;
    }

    private boolean isExcellentRating(String[] rating) {
        int count = 0;
        for (String str : rating) {
            if (Integer.parseInt(str) == 5) {
                count++;
            }
        }
        return count == rating.length;
    }
}
