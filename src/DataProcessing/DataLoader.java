package DataProcessing;

import DataGroups.*;
import Structures.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader implements IDataLoader{

    private String dataFilePath;

    // класс для заполнения списков данными (чтение из csv файла)
    public DataLoader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/path.txt"))) {
            this.dataFilePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // добавляем всех учеников из файла без доп критериев
    public void addAllPerson(IDataGroups dataGroup){
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            reader.readLine(); // пропускаем первую строку названий столбцов
            while ((line = reader.readLine()) != null) {
                String[] csvLine = line.split(";");
                dataGroup.addPerson(new Person(csvLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
