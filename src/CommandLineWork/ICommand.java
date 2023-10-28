package CommandLineWork;

import Structures.Person;

// 3) Выделить интерфейс Command, наследники которого будет отвечать за обработку конкретных консольных команд.
public interface ICommand {

    double getAverageRatingByGroup(int groupNum);
    Person[] getExcellentOlder(int age);
    Person[] getByLastName(String lastName);

}
