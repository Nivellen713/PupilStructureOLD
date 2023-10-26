import DataGroups.ClassroomDataGroups;
import DataGroups.PersonAgeDataGroups;
import DataGroups.PersonNameDataGroup;
import DataProcessing.DataReader;
import DataProcessing.DataWork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        DataWork dataWork = new DataWork();

        PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
        dataReader.addAllPerson(personAgeDataGroups);

        ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
        dataReader.addAllPerson(classroomDataGroups);

        PersonNameDataGroup personNameDataGroup = new PersonNameDataGroup();
        dataReader.addAllPerson(personNameDataGroup);
        // 1) Вычисление средней оценки в старших классах (10 и 11)
        double tenElevenAverageRating =
                (dataWork.getAverageRating(classroomDataGroups.getPersonByGroup(10)) +
                        dataWork.getAverageRating(classroomDataGroups.getPersonByGroup(11))) / 2;
        System.out.println(tenElevenAverageRating);

        // 2) Поиск всех отличников, старше 14 лет
        System.out.println(Arrays.deepToString(personAgeDataGroups.getExcellentOlderThan(6)));

        // 3) Поиск ученика по фамили (фамилия ученика задается через консоль)
        System.out.println(Arrays.toString(personNameDataGroup.getByLastName("Савельев")));


    }
}