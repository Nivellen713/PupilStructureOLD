package DataGroups;

import Structures.Person;

import java.util.Arrays;

// Класс-наследник для хранения данных по имени
public class PersonNameDataGroup extends DataGroups{
    private final String firstLetter;
    private int firstEmptyElemIndex = 0;
    private Person[] persons = new Person[1000];

    public PersonNameDataGroup(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    // Проверяем подходит ли ученик для данной группы элементов,
    // также увеличиваем хранилище на 1000 в случае его заполненности
    @Override
    public void addPerson(Person person) {
        if(person.getLastName().startsWith(firstLetter)) {
            if (firstEmptyElemIndex < persons.length - 1) {
                persons[firstEmptyElemIndex] = person;
                firstEmptyElemIndex++;
            } else {
                Person[] bufferPersons = persons;
                persons = new Person[bufferPersons.length + 1000];
                System.arraycopy(bufferPersons, 0, persons, 0, bufferPersons.length);

                persons[firstEmptyElemIndex] = person;
                firstEmptyElemIndex++;
            }
        } else {
            System.out.printf("Фамилия ученика начинается с  %s. Здесь фамилия должна начинаться с %s%n"
                    , person.getLastName(), firstLetter);
        }
    }

    // удаляем нулевые элементы
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
        return "PersonNameDataGroup{" +
                ", firstLetter='" + firstLetter + '\'' +
                ", firstEmptyElemIndex=" + firstEmptyElemIndex +
                ", persons=" + Arrays.toString(getPersons()) +
                '}';
    }
}