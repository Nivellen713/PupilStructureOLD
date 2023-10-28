package DataProcessing;

import DataGroups.IDataGroups;

//4) Выделить интерфейс DataLoader и реализовать его конкретный вариант загрузки данных из файла.
public interface IDataLoader {

    void addAllPerson(IDataGroups dataGroups);
}
