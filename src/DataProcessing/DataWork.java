package DataProcessing;

import Structures.Person;

// Класс для обработки данных и нахождения учеников по заданным параметрам
public class DataWork {

//     вычисление средней оценки группы учеников
    public double getAverageRating(Person[] persons) {
        double ratingSum = 0;
        double ratingAmount = 0;
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
}
