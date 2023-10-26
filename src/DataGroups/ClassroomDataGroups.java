package DataGroups;

import Structures.Person;

// Класс-наследник для хранения данных по учебным группам
public class ClassroomDataGroups implements IDataGroups {
    private final int SIZE = 1000;
    private final int GROUPS_AMOUNT = 12;     // количество классов (от 1 до 12 включительно)
    Person[][] persons = new Person[GROUPS_AMOUNT][SIZE];

    @Override
    public void addPerson(Person person) {
        int groupIndex = parseKeyToIndex(person.getGroup());
        int firstNullIndex = getFirstNullIndex(persons[groupIndex]);
        if (firstNullIndex == persons[groupIndex].length) {
            persons[groupIndex] = increaseArray(persons[groupIndex]);
        }
        persons[groupIndex][firstNullIndex] = person;
    }

    @Override
    public Person[][] getPersons() {
        return persons;
    }

    @Override
    public int parseKeyToIndex(int key) {
        return key - 1;
    }

    public Person[] getPersonByGroup(int group) {
        return persons[parseKeyToIndex(group)];
    }
}

