package DataGroups;

import Structures.Person;

import java.util.Arrays;

// Супер класс для хранения данных
public class DataGroups {
    private int firstEmptyElem = 0;
    private Person[] persons = new Person[1000];

    // добавление учеников, в случае нехватки массива увеличиваем его на 1000 элементов
    public void addPerson(Person person) {
        if (firstEmptyElem < persons.length - 1) {
            persons[firstEmptyElem] = person;
            firstEmptyElem++;
        } else {
            Person[] bufferPersons = persons;
            persons = new Person[bufferPersons.length + 1000];
            System.arraycopy(bufferPersons, 0, persons, 0, bufferPersons.length);

            persons[firstEmptyElem] = person;
            firstEmptyElem++;
        }
    }

    // линейный поиск с конца, так как null элементов максимум 1000 (см. метод addPerson класса DataGroups)
    // необходимо найти ПЕРВЫЙ null элемент массива

    // в классах наследниках данный код копируется, а не наследуется для корректной работы
    // (иначе массивы не заполняются или не удаляются null элементы)
    private void cutNullElements() {
        int indexOfNullElem = persons.length - 1;
        for (int i = persons.length - 1; persons[i] == null && i > 0; i--) {
            indexOfNullElem = i;
        }
        Person[] bufferPersons = persons;
        persons = new Person[indexOfNullElem];
        System.arraycopy(bufferPersons, 0, persons, 0, indexOfNullElem);
    }

    public Person[] getPersons() {
        cutNullElements();
        return persons;
    }

    @Override
    public String toString() {
        return "DataGroups{" +
                ", persons=" + Arrays.toString(getPersons()) +
                '}';
    }
}
