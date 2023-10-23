import DataGroups.ClassroomDataGroups;
import DataGroups.DataGroups;
import DataProcessing.DataReader;
import DataProcessing.DataWork;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        DataWork dataWork = new DataWork();

        // 1) Вычисление средней оценки в старших классах (10 и 11)
        DataGroups tenClassroomDataGroups = new ClassroomDataGroups(10);
        tenClassroomDataGroups = dataReader.addAllPerson(tenClassroomDataGroups);

        DataGroups elevenClassroomDataGroups = new ClassroomDataGroups(11);
        elevenClassroomDataGroups = dataReader.addAllPerson(elevenClassroomDataGroups);

        System.out.println("Средняя оценка десятых классов: " + dataWork.getAverageRating(tenClassroomDataGroups));
        System.out.println("Средняя оценка одиннадцатых классов: " + dataWork.getAverageRating(elevenClassroomDataGroups));

        System.out.println("Средняя оценка 10 и 11 классов: "
                + (dataWork.getAverageRating(tenClassroomDataGroups)
                + dataWork.getAverageRating(elevenClassroomDataGroups)) / 2);

        //2) Поиск всех отличников, старше 14 лет
        DataGroups dataGroups = new DataGroups();
        dataGroups = dataReader.addAllPerson(dataGroups);
        System.out.println("Отличники старше 14ти: " + dataWork.getExcellentOlder(dataGroups, 14));

        // 3) Поиск ученика по фамилии (фамилия ученика задается через консоль)
        System.out.println(dataWork.getByLastName(dataGroups));

    }
}