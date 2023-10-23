package DataGroups;

import Structures.Person;

import java.util.Arrays;

// Класс-наследник для хранения данных по возрасту
public class PersonAgeDataGroups extends DataGroups{
    private final int age;
    private int firstEmptyElem = 0;
    private Person[] persons = new Person[1000];

    public PersonAgeDataGroups(int age) {
        this.age = age;
    }

    // Проверяем подходит ли ученик для данной группы элементов,
    // также увеличиваем хранилище на 1000 в случае его заполненности
    @Override
    public void addPerson(Person person) {
        if(person.getAge() == age) {
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
        } else {
            System.out.printf("Ученик возраста %d. Здесь возраст %d%n", person.getGroup(), age);
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
        return "PersonAgeDataGroups{" +
                ", age=" + age +
                ", firstEmptyElem=" + firstEmptyElem +
                ", persons=" + Arrays.toString(getPersons()) +
                '}';
    }
}
