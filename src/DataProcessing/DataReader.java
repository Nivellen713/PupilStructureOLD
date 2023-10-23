package DataProcessing;

import DataGroups.*;
import Structures.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    private String dataFilePath;

    // класс для заполнения списков данными (чтение из csv файла)
    public DataReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/path.txt"))) {
            this.dataFilePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // добавляем всех учеников из файла без доп критериев,
    // так как классы DataGroups сами определяеют добавлять им ученика или нет
    public DataGroups addAllPerson(DataGroups dataGroups){
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            reader.readLine(); // пропускаем первую строку названий столбцов
            while ((line = reader.readLine()) != null) {
                String[] csvLine = line.split(";");
                dataGroups.addPerson(new Person(csvLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataGroups;
    }

}
