package DataGroups;

import Structures.Person;

import java.util.Arrays;

// Класс-наследник для хранения данных по учебным группам
public class ClassroomDataGroups extends DataGroups {

    private final int groupNum;
    private int firstEmptyElem = 0;
    private Person[] persons = new Person[1000];

    public ClassroomDataGroups(int groupNum) {
        this.groupNum = groupNum;
    }

    // Проверяем подходит ли ученик для данной группы элементов,
    // также увеличиваем хранилище на 1000 в случае его заполненности
    @Override
    public void addPerson(Person person) {
        if (person.getGroup() == groupNum) {
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
    }

    // обрезаем все нулевые элементы
    private void cutNullElements() {
        int indexOfNullElem = persons.length - 1;
        for (int i = persons.length - 1; persons[i] == null && i > 0; i--) {
            indexOfNullElem = i;
        }
        Person[] bufferPersons = persons;
        persons = new Person[indexOfNullElem];
        System.arraycopy(bufferPersons, 0, persons, 0, indexOfNullElem);
    }

    @Override
    public Person[] getPersons() {
        cutNullElements();
        return persons;
    }

    @Override
    public String toString() {
        return "ClassroomDataGroups{" +
                "groupNum=" + groupNum +
                ", firstEmptyElem=" + firstEmptyElem +
                ", persons=" + Arrays.toString(getPersons()) +
                '}';
    }
}

